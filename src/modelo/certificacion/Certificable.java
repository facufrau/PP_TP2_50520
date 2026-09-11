package modelo.certificacion;

import modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "UTN-FRM";

    public String generarCertificado(Estudiante estudiante);
}
