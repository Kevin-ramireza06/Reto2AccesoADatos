/*package Reto2;

import com.google.gson.Gson;

import org.json.JSONObject;
import org.json.XML;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertirXmlAJSON {

    static public class Persona {
        int id;
        String first_name;
        String last_name;
        String email;
        String gender;
    }

    public static void main(String[] args) {

        /*Aqui estamos usando las librerias gson y org json

        try{
            String json = new String(Files.readAllBytes(Paths.get("MOCK_DATA.json")));
            //Aqui leemos el json masivo que craemos
            Gson gson = new Gson();
            Persona[] personas = gson.fromJson(json, Persona[].class);
            //Aqui transformamos el json a gson, de la clase persona, en la clase debemos de tener
            // atributos que puedan guardar los objetos del gson

            for (Persona index : personas){
                JSONObject jsonObject = new JSONObject(gson.toJson(index));

                String xml = XML.toString(jsonObject,"Personas");
                System.out.println(xml);
            } //Aqui lo recorremos y lo hacemos xml, y lo vamos mostrando

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}*/
