public class ChefAI_Main {

    public static void main(String[] args) {

        LLMClient client;

        if(args.length > 0 && args[0].equalsIgnoreCase("mock")){
            System.out.println(">> Modo MOCK ativado");
            client = new MockLLMClient();
        } else {
            System.out.println(">> Modo REAL (simulado)");
            client = new RealLLMClient();
        }

        ChefAI app = new ChefAI(client);
        app.start();
    }
}
