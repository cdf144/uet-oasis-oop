package com.nordstrom.common.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nordstrom.common.file.OSInfo.OSType;

public class VolumeInfo {
    
    static final boolean IS_WINDOWS = (OSInfo.getDefault().getType() == OSType.WINDOWS);
    
    private VolumeInfo() {
        throw new AssertionError("VolumeInfo is a static utility class that cannot be instantiated");
    }
    
    public static Map<String, VolumeProps> getVolumeProps() throws IOException {
        Process mountProcess;
        if (IS_WINDOWS) {
            String[] cmd = {"sh", "-c", "mount | grep noumount"};
            mountProcess = Runtime.getRuntime().exec(cmd);
        } else {
            mountProcess = Runtime.getRuntime().exec("mount");
        }
        return getVolumeProps(mountProcess.getInputStream());
    }

    public static Map<String, VolumeProps> getVolumeProps(InputStream is) throws IOException {
        Map<String, VolumeProps> propsList = new HashMap<>();
        Pattern template = Pattern.compile("(.+) on (.+) type (.+) \\((.+)\\)");
        
        InputStreamReader isr = new InputStreamReader(is);
        try(BufferedReader mountOutput = new BufferedReader(isr)) {
            String line;
            while(null != (line = mountOutput.readLine())) {
                Matcher matcher = template.matcher(line);
                if (matcher.matches()) {
                    String spec = matcher.group(1);
                    String file = matcher.group(2);
                    String type = matcher.group(3);
                    String[] opts = matcher.group(4).split(",");
                    VolumeProps props = new VolumeProps(spec, file, type, opts);
                    if (props.size > 0L) {
                        propsList.put(spec, props);
                    }
                }
            }
        }
        return propsList;
    }
    
    public static class VolumeProps {
        
        String file;
        String type;
        String[] opts;
        
        private long size;
        private long free;
        
        VolumeProps(String spec, String file, String type, String... opts) {
            if (IS_WINDOWS) {
                this.file = spec;
            } else {
                this.file = file;
            }
            
            this.type = type;
            this.opts = opts;
            
            File f = new File(this.file);
            this.size = f.getTotalSpace();
            this.free = f.getFreeSpace();
        }
        
        public String getFile() {
            return file;
        }

        public String getType() {
            return type;
        }

        public String[] getOpts() {
            return opts;
        }
        
        public long getSize() {
            return size;
        }
        public long getFree() {
            return free;
        }
    }
}
