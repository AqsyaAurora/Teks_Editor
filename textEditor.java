import java.util.Scanner;
import java.util.Stack;

class TextEditor {
    private String text;  // Teks saat ini
    private Stack<String> undoStack;  // Stack untuk undo (menyimpan state sebelumnya)
    private Stack<String> redoStack;  // Stack untuk redo (menyimpan state setelah undo)

    public TextEditor() {
        this.text = "";
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void write(String newText) {
        // Simpan state saat ini ke undoStack sebelum menambah teks
        undoStack.push(text);
        // Tambahkan teks baru
        text += newText;
        // Kosongkan redoStack karena ada perubahan baru
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            // Simpan state saat ini ke redoStack
            redoStack.push(text);
            // Kembalikan ke state sebelumnya
            text = undoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            // Simpan state saat ini ke undoStack
            undoStack.push(text);
            // Pulihkan ke state yang lebih baru
            text = redoStack.pop();
        } else {
            System.out.println("Tidak ada yang bisa di-redo.");
        }
    }

    public void show() {
        System.out.println("Teks saat ini: '" + text + "'");
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simulasi Text Editor");
        System.out.println("Perintah yang tersedia:");
        System.out.println("- write <teks>: Menambahkan teks");
        System.out.println("- undo: Mengembalikan ke state sebelumnya");
        System.out.println("- redo: Memulihkan ke state yang lebih baru");
        System.out.println("- show: Menampilkan teks saat ini");
        System.out.println("- exit: Keluar dari program");
        System.out.println();

        while (true) {
            System.out.print("Masukkan perintah: ");
            String command = scanner.nextLine().trim();
            if (command.startsWith("write ")) {
                String text = command.substring(6);  // Ambil teks setelah "write "
                editor.write(text);
            } else if (command.equals("undo")) {
                editor.undo();
            } else if (command.equals("redo")) {
                editor.redo();
            } else if (command.equals("show")) {
                editor.show();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Perintah tidak valid. Coba lagi.");
            }
        }
        scanner.close();
    }
}
