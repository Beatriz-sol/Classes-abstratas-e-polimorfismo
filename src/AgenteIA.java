public abstract class AgenteIA {

    protected String nome;
    protected String status;

    public AgenteIA(String nome) {
        this.nome = nome;
        this.status = "IDLE";
    }

    public String getNome() {
        return nome;
    }

    public void conectarServidor()
            throws ErroComunicacaoIAException {

        System.out.println(
            "Conectando ao servidor para o agente " + nome
        );
    }

    public abstract void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException;
}