public class PluginPesquisaWeb implements IAcaoAgente {

    @Override
    public void executar(String comando)
            throws PromptInadequadoException,
                   FalhaProcessamentoAgenteException {

        if (comando.equalsIgnoreCase("hackear")
   