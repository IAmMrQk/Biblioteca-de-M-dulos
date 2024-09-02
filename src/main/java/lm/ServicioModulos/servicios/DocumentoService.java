package lm.ServicioModulos.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lm.ServicioModulos.modelos.entidad.Documentos;
import lm.ServicioModulos.modelos.repositorio.DocumentoRepositorio;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepositorio documentoRepositorio;

    public Documentos guardarDocumento(String nombre, byte[] archivoPdf) {
        Documentos documento = new Documentos();
        documento.setNombre(nombre);
        documento.setArchivoPdf(archivoPdf);
        return documentoRepositorio.save(documento);
    }

    public Optional<Documentos> obtenerDocumentoPorId(Long id) {
        return documentoRepositorio.findById(id);
    }
}
