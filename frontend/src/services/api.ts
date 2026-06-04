const BASE_URL = "http://localhost:8080/api/books";

export async function getBooks(search = "", filter = "all") {
  const res = await fetch(`${BASE_URL}?search=${search}&filter=${filter}`);
  return res.json();
}

export async function createBook(title: string, author: string) {
  const res = await fetch(BASE_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, author }),
  });

  return res.json();
}

export async function toggleBorrow(id: number) {
  const res = await fetch(`${BASE_URL}/${id}/borrow`, {
    method: "PUT",
  });

  return res.json();
}

export async function deleteBook(id: number) {
  await fetch(`${BASE_URL}/${id}`, {
    method: "DELETE",
  });
}