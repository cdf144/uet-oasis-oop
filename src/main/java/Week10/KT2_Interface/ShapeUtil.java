package Week10.KT2_Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapeUtil {
    /**
     * Print info of object list.
     * @param shapes shapes list
     * @return info string
     */
    public String printInfo(List<GeometricObject> shapes) {
        if (shapes == null) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        Map<String, List<GeometricObject>> shapesGroupMap = new HashMap<>();
        shapesGroupMap.put("Circle", null);
        shapesGroupMap.put("Triangle", null);

        for (GeometricObject shape : shapes) {
            try {
                if (shape instanceof Circle) {
                    if (shapesGroupMap.get("Circle") == null) {
                        List<GeometricObject> circleList = new ArrayList<>();
                        circleList.add((Circle) shape);
                        shapesGroupMap.put("Circle", circleList);
                    } else {
                        shapesGroupMap.get("Circle").add((Circle) shape);
                    }
                } else if (shape instanceof Triangle) {
                    if (shapesGroupMap.get("Triangle") == null) {
                        List<GeometricObject> triangleList = new ArrayList<>();
                        triangleList.add((Triangle) shape);
                        shapesGroupMap.put("Triangle", triangleList);
                    } else {
                        shapesGroupMap.get("Triangle").add((Triangle) shape);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        if (shapesGroupMap.get("Circle") != null) {
            output.append("Circle:\n");
            for (GeometricObject circle : shapesGroupMap.get("Circle")) {
                output.append(circle.getInfo()).append("\n");
            }
        } else {
            output.append("Triangle:\n");
            for (GeometricObject triangle : shapesGroupMap.get("Triangle")) {
                output.append(triangle.getInfo()).append("\n");
            }
            return output.toString();
        }

        if (shapesGroupMap.get("Triangle") != null) {
            output.append("Triangle:\n");
            for (GeometricObject triangle : shapesGroupMap.get("Triangle")) {
                output.append(triangle.getInfo()).append("\n");
            }
        } else {
            return output.toString();
        }

        return output.toString();
    }
}
