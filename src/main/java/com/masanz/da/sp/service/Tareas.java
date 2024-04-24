package com.masanz.da.sp.service;

import com.masanz.da.sp.dto.Producto;

import java.util.ArrayList;
import java.util.List;

public class Tareas {

    public List<Producto> obtenerProductos() {
        String[] productos = {"Green Mouse", "Blue Keyboard", "Pink ATX ", "Tiny USB C", "Black Router"};

        List<Producto> result = new ArrayList<>();
        for (String nombre : productos) {
            result.add(new Producto(nombre,
                    "products/" + nombre.replaceAll("\s","").toLowerCase() + ".html"));
        }

        return result;
    }

}
