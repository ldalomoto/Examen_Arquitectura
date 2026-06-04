import { useEffect, useState } from "react";
import { type Book } from "../types/Book";
import { BookCard } from "../components/BookCard";
import { BookForm } from "../components/BookForm";
import {
  getBooks,
  createBook,
  toggleBorrow,
  deleteBook,
} from "../services/api";

import "../App.css";

export default function Books() {
  const [books, setBooks] = useState<Book[]>([]);
  const [search, setSearch] = useState("");
  const [filter, setFilter] = useState("all");

  const load = async () => {
    const data = await getBooks(search, filter);
    setBooks(data);
  };

  useEffect(() => {
    load();
  }, [search, filter]);

  const handleAdd = async (title: string, author: string) => {
    await createBook(title, author);
    load();
  };

  const handleToggle = async (id: number) => {
    await toggleBorrow(id);
    load();
  };

  const handleDelete = async (id: number) => {
    await deleteBook(id);
    load();
  };

  return (
    <div className="max-w-3xl mx-auto p-6">
      <h1 className="text-2xl font-bold mb-4">Library</h1>

      {/* SEARCH + FILTER */}
      <div className="flex gap-2 mb-4">
        <input
          className="border p-2 w-full"
          placeholder="Search..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />

        <select
          className="border p-2"
          value={filter}
          onChange={(e) => setFilter(e.target.value)}
        >
          <option value="all">All</option>
          <option value="available">Available</option>
          <option value="borrowed">Borrowed</option>
        </select>
      </div>

      <BookForm onAdd={handleAdd} />

      <div className="space-y-3">
        {books.map((b) => (
          <BookCard
            key={b.id}
            book={b}
            onToggle={handleToggle}
            onDelete={handleDelete}
          />
        ))}
      </div>
    </div>
  );
}