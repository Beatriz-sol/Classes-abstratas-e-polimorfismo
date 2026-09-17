import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://aws-0-us-east-1.pooler.supabase.com:5432/postgres";
        String username = "postgres.tzdiskpmctmaxozfoldj";
        String password = "@VidaGi0309";

        Connection con = DriverManager.getConnection(url, username, password);

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println();
            System.out.println("===== SISTEMA DE RESERVAS DE HOTEL =====");
            System.out.println("1 - Inserir hóspede");
            System.out.println("2 - Listar hóspedes");
            System.out.println("3 - Alterar hóspede");
            System.out.println("4 - Remover hóspede");
            System.out.println("5 - Inserir reserva");
            System.out.println("6 - Listar reservas");
            System.out.println("7 - Alterar reserva");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:
                    inserirHospede(con, scanner);
                    break;

                case 2:
                    listarHospedes(con);
                    break;

                case 3:
                    alterarHospede(con, scanner);
                    break;

                case 4:
                    removerHospede(con, scanner);
                    break;

                case 5:
                    inserirReserva(con, scanner);
                    break;

                case 6:
                    listarReservas(con);
                    break;

                case 7:
                    alterarReserva(con, scanner);
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
        con.close();
    }

    static void inserirHospede(Connection con, Scanner scanner) throws Exception {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        String sql = "INSERT INTO hospede (nome, telefone) VALUES (?, ?)";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, nome);
        pstmt.setString(2, telefone);

        int qte = pstmt.executeUpdate();

        if (qte >= 1) {
            System.out.println("Hóspede inserido com sucesso!");
        }

        pstmt.close();
    }

    static void listarHospedes(Connection con) throws Exception {

        String sql = "SELECT * FROM hospede";

        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        System.out.println();
        System.out.println("===== HÓSPEDES =====");

        while (rs.next()) {

            System.out.println(
                rs.getInt("id") + " - " +
                rs.getString("nome") + " - " +
                rs.getString("telefone")
            );
        }

        rs.close();
        pstmt.close();
    }

    static void alterarHospede(Connection con, Scanner scanner) throws Exception {

        System.out.print("Digite o ID do hóspede: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        String sql = "UPDATE hospede SET nome = ?, telefone = ? WHERE id = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setString(1, nome);
        pstmt.setString(2, telefone);
        pstmt.setInt(3, id);

        int qte = pstmt.executeUpdate();

        if (qte >= 1) {
            System.out.println("Hóspede alterado com sucesso!");
        } else {
            System.out.println("Hóspede não encontrado.");
        }

        pstmt.close();
    }

    static void removerHospede(Connection con, Scanner scanner) throws Exception {

        System.out.print("Digite o ID do hóspede: ");
        int id = Integer.parseInt(scanner.nextLine());

        String sql = "DELETE FROM hospede WHERE id = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, id);

        int qte = pstmt.executeUpdate();

        if (qte >= 1) {
            System.out.println("Hóspede removido com sucesso!");
        } else {
            System.out.println("Hóspede não encontrado.");
        }

        pstmt.close();
    }

    static void inserirReserva(Connection con, Scanner scanner) throws Exception {

        System.out.print("ID do hóspede: ");
        int hospedeId = Integer.parseInt(scanner.nextLine());

        System.out.print("Data de check-in (AAAA-MM-DD): ");
        String data = scanner.nextLine();

        String sql = "INSERT INTO reserva (hospede_id, data_checkin) VALUES (?, ?)";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, hospedeId);
        pstmt.setDate(2, java.sql.Date.valueOf(data));

        int qte = pstmt.executeUpdate();

        if (qte >= 1) {
            System.out.println("Reserva inserida com sucesso!");
        }

        pstmt.close();
    }

    static void listarReservas(Connection con) throws Exception {

        String sql = "SELECT * FROM reserva";

        PreparedStatement pstmt = con.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();

        System.out.println();
        System.out.println("===== RESERVAS =====");

        while (rs.next()) {

            System.out.println(
                rs.getInt("id") + " - " +
                "Hóspede: " + rs.getInt("hospede_id") + " - " +
                "Check-in: " + rs.getDate("data_checkin")
            );
        }

        rs.close();
        pstmt.close();
    }

    static void alterarReserva(Connection con, Scanner scanner) throws Exception {

        System.out.print("Digite o ID da reserva: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo ID do hóspede: ");
        int hospedeId = Integer.parseInt(scanner.nextLine());

        System.out.print("Nova data de check-in (AAAA-MM-DD): ");
        String data = scanner.nextLine();

        String sql = "UPDATE reserva SET hospede_id = ?, data_checkin = ? WHERE id = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, hospedeId);
        pstmt.setDate(2, java.sql.Date.valueOf(data));
        pstmt.setInt(3, id);

        int qte = pstmt.executeUpdate();

        if (qte >= 1) {
            System.out.println("Reserva alterada com sucesso!");
        } else {
            System.out.println("Reserva não encontrada.");
        }

        pstmt.close();
    }
}