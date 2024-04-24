package com.masanz.da.sp;

import com.masanz.da.sp.dto.Producto;
import com.masanz.da.sp.service.Tareas;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Demo {

    private static Configuration cfg;

    private static Tareas tareas;


    /**
     * Ejemplo de freemarker basado en:
     * https://freemarker.apache.org/docs/pgui_quickstart_all.html
     * Genera el fichero ejemplo.html en la carpeta "salida"
     * Es necesario que en esta carpeta se encuentren los recursos estáticos
     * y se haga referencia a ellos en base a rutas relativas
     * @param args No necesita
     * @throws Exception Para simplificar el código
     */
    public static void main(String[] args) throws Exception {
        setCfg();

        tareas = new Tareas();

        cocinaEjemplo();
    }

    private static void setCfg() {
        cfg = new Configuration(Configuration.VERSION_2_3_32);

        // Respecto de la clase Main dónde están las plantillas en la estructura de paquetes
        cfg.setClassForTemplateLoading(Demo.class, "./templates");

        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
    }

    private static void cocinaEjemplo() throws Exception {
        String fichero = "ejemplo";

        Map model = new HashMap();

        model.put("usuario", "Aitor");

        Producto ultimoProducto = new Producto();
        ultimoProducto.setUrl("products/greenmouse.html");
        ultimoProducto.setNombre("Green Mouse");
        model.put("ultimoProducto", ultimoProducto);

        model.put("productos", tareas.obtenerProductos());

        cocina(fichero, model);
    }

    private static void cocina(String fichero, Map model) throws Exception {
        Template temp = cfg.getTemplate(fichero + ".ftl");

//        Writer out = new OutputStreamWriter(System.out);

        File file = new File("salida/" + fichero + ".html");
        Writer out = new OutputStreamWriter(new FileOutputStream(file));

        temp.process(model, out);
    }

}
