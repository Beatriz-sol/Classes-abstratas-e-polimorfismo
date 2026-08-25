public class ModuloConexao {

    public static void validarLink()
            throws ErroComunicacaoIAException {

        double numero = Math.random();

        if (numero > 0.8) {

            throw new ErroComunicacaoIAException("Falha na comunicação com a GPU.");
        }

        System.out.println("Conexão estabelecida com sucesso.");
    }
}