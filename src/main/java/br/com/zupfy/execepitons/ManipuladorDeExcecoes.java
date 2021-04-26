package br.com.zupfy.execepitons;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.logging.Logger;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> manipuladorGenerico(RuntimeException e){
        HashMap<String, String> map = new HashMap();
        map.put("mensagem", e.getMessage());
        return ResponseEntity.status(422).body(map);
    }
}
