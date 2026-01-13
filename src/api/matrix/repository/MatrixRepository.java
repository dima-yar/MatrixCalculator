package api.matrix.repository;

import api.GUI.ApplicationMain;
import api.matrix.domain.Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MatrixRepository {
    public static String currentMatrix = null;
    private static final Map<String, Matrix> MATRICES = new HashMap<String, Matrix>();

    public static void putMatrix(Matrix matrix) {
        MATRICES.put(matrix.getName(), matrix);
    }
    public static Matrix getMatrix(String name) {
        return MATRICES.get(name);
    }
    public static void deleteMatrix(String name) {
        MATRICES.remove(name);
    }
    public static boolean containsMatrix(String name){
        return MATRICES.containsKey(name);
    }
    public static Set<String> getNames(){
        return MATRICES.keySet();
    }
    public static void setCurrrentMatrix(String matrixName) {
        MatrixRepository.currentMatrix = matrixName;
        ApplicationMain.frame.sideBar.setCurrentMatrix(MatrixRepository.currentMatrix);
    }
}
