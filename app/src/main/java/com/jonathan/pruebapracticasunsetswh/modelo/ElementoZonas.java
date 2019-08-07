package com.jonathan.pruebapracticasunsetswh.modelo;

import java.util.ArrayList;
import java.util.List;

public class ElementoZonas {
    private String date;
    public List<stations> stations = null;

   public class stations{
       public long idStation;
       public String name;
       public String desc;
       public List<items>  items = null;

       public class items{
           public int idSitio;
           public int orderSitio;
           public String name;
           public String address;
           public String description;
           public Double lat;
           public Double lon;
           public String type;
           public int capacity;
           public int bikes;
           public String places;
           public String picture;
           public String bikesState;
           public String placesState;
           public int closed;
           public int cdo;
       }
   }
}
