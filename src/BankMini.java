import java.util.Scanner;

public class BankMini {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rekening rekening = new Rekening("001", "Ani", 100000);

        System.out.println("============ BANK MINI ============");
        System.out.println("Rekening " + rekening.getNomor() + " a.n. " + rekening.getPemilik());

        int menu;
        do {
            System.out.print("Menu (1 setor, 2 tarik, 3 info, 0 keluar): ");
            menu = input.nextInt();

            switch (menu) {
                case 1 -> {
                    System.out.print("Jumlah: ");
                    boolean berhasil = rekening.setor(input.nextInt());
                    System.out.println(berhasil ? "  Berhasil" : "  Ditolak");
                }
                case 2 -> {
                    System.out.print("Jumlah: ");
                    boolean berhasil = rekening.tarik(input.nextInt());
                    System.out.println(berhasil ? "  Berhasil" : "  Ditolak");
                }
                case 3 -> rekening.cetakInfo();
                case 0 -> { }
                default -> System.out.println("  Menu tidak dikenal");
            }
        } while (menu != 0);

        System.out.println();
        System.out.println("=========== SALDO AKHIR ===========");
        rekening.cetakInfo();
        // Percobaan mengubah saldo langsung dari luar class. Hasilnya error saat di-compile.
        // Pesan error: saldo has private access in Rekening
        // rekening.saldo = 1000000; -Baris ini dijadikan komentar supaya program bisa di-compile lagi.
        input.close();
    }
}