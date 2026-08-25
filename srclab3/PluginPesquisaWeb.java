public class PluginPesquisaWeb implements IAcaoAgente {

    @Override
    public void executar(String comando)
            throws PromptInadequadoException,
                   FalhaProcessamentoAgenteException {

        if (comando.toLowerCase().contains("hackear")
                || comando.toLowerCase().contains("roubar")) {

            throw new PromptInadequadoException(
                "Comando bloqueado pelo plugin de pesquisa."
            );
        }

        System.out.println(
            "Resultado da pesquisa no Google sobre: " + comando
        );
    }
}