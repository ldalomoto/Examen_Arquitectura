import { type Book } from "../types/Book";

type Props = {
  book: Book;
  onToggle: (id: number) => void;
  onDelete: (id: number) => void;
};

export function BookCard({ book, onToggle, onDelete }: Props) {
  return (
    <div className="border p-4 rounded-lg flex justify-between items-center">
      <div>
        <h2 className="font-bold">{book.title}</h2>
        <p className="text-sm text-gray-500">{book.author}</p>

        <p className={book.borrowed ? "text-red-500" : "text-green-600"}>
          {book.borrowed ? "Borrowed" : "Available"}
        </p>
      </div>

      <div className="flex gap-2">
        <button
          className="px-3 py-1 bg-blue-600 text-white rounded"
          onClick={() => onToggle(book.id)}
        >
          Toggle
        </button>

        <button
          className="px-3 py-1 bg-red-600 text-white rounded"
          onClick={() => onDelete(book.id)}
        >
          Delete
        </button>
      </div>
    </div>
  );
}