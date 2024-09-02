package lm.ServicioModulos.web.controladores;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lm.ServicioModulos.modelos.entidad.Documentos;
import lm.ServicioModulos.servicios.DocumentoService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/documentos")
public class DocumentoControlador {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/subir")
    public String subirDocumento(@RequestParam("nombre") String nombre,
            @RequestParam("archivo") MultipartFile archivo) {
        try {
            byte[] archivoPdf = archivo.getBytes(); // Convertir MultipartFile a byte[]
            documentoService.guardarDocumento(nombre, archivoPdf); // Guardar usando byte[]
            return "Archivo subido exitosamente";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al subir el archivo: " + e.getMessage();
        }
    }

    // Endpoint para descargar un archivo PDF
    @GetMapping("/descargar/{id}")
    public ResponseEntity<byte[]> descargarDocumento(@PathVariable Long id) {
        Optional<Documentos> documento = documentoService.obtenerDocumentoPorId(id);
        if (documento.isPresent()) {
            byte[] archivoPdf = documento.get().getArchivoPdf();
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=documento.pdf");
            return new ResponseEntity<>(archivoPdf, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/vista-previa/{id}")
    public ResponseEntity<byte[]> vistaPreviaDocumento(@PathVariable Long id) {
        Optional<Documentos> documento = documentoService.obtenerDocumentoPorId(id);
        if (documento.isPresent()) {
            byte[] archivoPdf = documento.get().getArchivoPdf();
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=documento.pdf");
            return new ResponseEntity<>(archivoPdf, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
