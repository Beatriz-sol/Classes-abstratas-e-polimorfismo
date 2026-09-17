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

        inserirHospede(con, scanner);

        listarHospedes(con);

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
}