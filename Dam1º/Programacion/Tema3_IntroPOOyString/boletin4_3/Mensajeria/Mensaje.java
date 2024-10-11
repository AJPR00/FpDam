/*package boletin4_3.Mensajeria;

import java.time.LocalDateTime;

*//*2. Vamos a crear un programa de mensajería, donde unas personas podrán enviar un
        mensaje a otra persona. A continuación se definen las necesidades de cada
        elemento:
        ● Mensaje:
        ○ asunto, String
        ○ Cuerpo, String
        ○ fechaEnvío, LocalDate
        ○ remitente, Persona
        ○ destinatario, Persona
        ● Persona:
        ○ nombre, String
        ○ mensajesRecibidos
        ○ mensajesEnviados
        ○ método enviarMensaje. Debe comprobar que el mensaje tiene asunto,
        cuerpo y destinatario. Debe poner automáticamente el remitente y la fecha de
        envío. Además, debe añadir el mensaje a los buzones correspondientes de
        cada persona (mensajesRecibidos o mensajesEnviados). Los buzones
        tendrán una capacidad de 5 mensajes. Si el buzón está lleno, no podrá
        enviar o recibir ningún mensaje y se mostrará un error.
        ○ método borrarMensajeEnviadoMásAntiguo. Debe borrar el primer mensaje
        que haya en el buzón (posición 0). Si el buzón está vacío dará un error. Se
        deben reordenar todos los demás mensajes que haya en el buzón, es decir,
        el que ocupara la posición 1 pasará a ocupar la posición 0, el que ocupara la
        2, a la 1, etc.
        ○ método borrarMensajeRecibidoMásAntiguo. Misma lógica que el anterior
        pero en el buzón de recibidos.
        Realiza algunas pruebas de envío. Comprueba que los mensajes están en los
        buzones correspondiente. Intenta enviar mensajes cuando los buzones están llenos.*//*
public class Mensaje {

    private String asunto;
    private String cuerpo;
    private LocalDateTime fechaEnvio;
    private Personas remitente;
    private Personas destinatario;


    //CONSTRUCTOR
    public Mensaje(String asunto, String cuerpo, LocalDateTime fechaEnvio, Personas remitente, Personas destinatario) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaEnvio = LocalDateTime.now();
        this.remitente = remitente;
        this.destinatario = destinatario;

    }

    //GET
    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public Personas getRemitente() {
        return remitente;
    }

    public Personas getDestinatario() {
        return destinatario;
    }


    @Override
    public String toString() {
        return "Mensaje{" +
                "asunto='" + asunto + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                ", remitente=" + remitente +
                ", destinatario=" + destinatario +
                '}';
    }
}*/

