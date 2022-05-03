package co.edu.uniquindio.proyecto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class EmailServicioImp implements EmailServicio, Serializable {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void SendSimpleMessage(String to, String asunto, String text) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(asunto);
        msg.setText(text);

        mailSender.send(msg);
    }
}
