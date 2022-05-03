package co.edu.uniquindio.proyecto.servicios;

public interface EmailServicio {

    void SendSimpleMessage(String to, String asunto, String text);
}
