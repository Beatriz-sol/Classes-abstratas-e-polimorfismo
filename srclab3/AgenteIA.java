
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
    public void setNome(String nome) {
    this.nome = nome;
    }

    public void conectarServidor()
            throws ErroComunicacaoIAException {

        System.out.println("Conectando ao servidor para o agente " + nome);
    }

    public abstract void processarRequisicao(String input)
            throws FalhaProcessamentoAgenteException,
                   PromptInadequadoException,
                   ErroComunicacaoIAException;

    public void usarHabilidade (IAcaoAgente ferramenta,String comando)
            throws PromptInadequadoException,
               FalhaProcessamentoAgenteException {

    ferramenta.executar(comando);
    }

}