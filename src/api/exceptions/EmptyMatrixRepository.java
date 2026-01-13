package api.exceptions;

import api.matrix.repository.MatrixRepository;

public class EmptyMatrixRepository extends Exception {
    public EmptyMatrixRepository() {
        super("No matrices in repository");
    }
}
