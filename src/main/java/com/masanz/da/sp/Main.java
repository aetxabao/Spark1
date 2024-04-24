package com.masanz.da.sp;

import com.masanz.da.sp.dto.Producto;
import com.masanz.da.sp.service.Tareas;
import freemarker.template.Configuration;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    /**
     * Ejemplo de aplicación web con Spark
     * http://localhost:8080/ejemplo.html
     * los recursos estáticos se encuentran en la carpeta public
     * la plantilla ftl está en la carpeta templates
     * En el modelo para crear el documento html se pasan
     * un String, un objeto y una lista de objetos
     * @param args No necesita argumentos
     */
    public static void main(String[] args) {

        staticFileLocation("com/masanz/da/sp/public");
        port(8080);

        FreeMarkerEngine freeMarker = new FreeMarkerEngine();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setClassForTemplateLoading(Main.class, "templates");
        freeMarker.setConfiguration(configuration);

        Tareas tareas = new Tareas();

        get("/ejemplo.html", (request, response) -> {
            String fichero = "ejemplo";

            Map model = new HashMap();

            model.put("usuario", "Aitor");

            Producto ultimoProducto = new Producto();
            ultimoProducto.setUrl("products/greenmouse.html");
            ultimoProducto.setNombre("Green Mouse");
            model.put("ultimoProducto", ultimoProducto);

            model.put("productos", tareas.obtenerProductos());

            return new ModelAndView(model, fichero + ".ftl");
        }, freeMarker);

    }

}
