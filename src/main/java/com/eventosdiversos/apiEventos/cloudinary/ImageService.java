package com.eventosdiversos.apiEventos.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadImg(MultipartFile image, String folder){

        if(image == null) {
            System.out.println("Arquivo vazio");
        }

        try{
            Map options = new HashMap<>(); // Objeto chave-valor para armazenar configurações extras

            // Adiciona configurações extras caso exista uma pagina para armazenar as imagens
            if(folder != null && ! folder.isEmpty()) {
                options.put("folder", folder);
                options.put("use_filename", true);
                options.put("unique_name", true);
            }

            // Envia a imagem para o cloudinary e retorna a url
            Map uploadResult = cloudinary.uploader().upload(image.getBytes(), options);

            // Retorna a url de onde a imagem está hospedada
            return uploadResult.get("secure_url").toString();

        } catch (IOException e) {
            System.out.println("Falha ao Carregar Arquivo!");
            return null;
        }

    }
}
