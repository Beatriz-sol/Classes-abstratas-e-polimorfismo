import java.util.ArrayList;
import java.util.List;

public class Orquestrador {

    public static void main(String[] args) {

        List<AgenteIA> orquestrador = new ArrayList<>();

        orquestrador.add(
            new AgenteChat("GPT-4")
        );

        orquestrador.add(
            new AgenteImagem("DALL-E")
        );

        SafetyGuard.processarFila(
            orquestrador,
            "Como hackear um sistema?"
        );
    }
}