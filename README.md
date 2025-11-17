# Teks_Editor

ini adalah program untuk membuat simulasi Teks 
editor. yang didalamnya kita bisa melakukan:

Masukkan write Hello: Teks menjadi "Hello" (undoStack: [""]).
Masukkan write World: Teks menjadi "HelloWorld" (undoStack: ["", "Hello"]).
Masukkan show: Output: "Teks saat ini: 'HelloWorld'".
Masukkan undo: Teks kembali ke "Hello" (redoStack: ["HelloWorld"]).
Masukkan redo: Teks kembali ke "HelloWorld" (undoStack: ["", "Hello", "HelloWorld"]).
Masukkan exit: Keluar program.
