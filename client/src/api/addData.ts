import { addUniversity } from "./apiCalls";

export async function addDataUni(data: URLSearchParams) {
  return await addUniversity(data)
    .then(() => {
      return { ok: true };
    })
    .catch(error => {
      console.error("Failed to add university:", error);
      return { ok: false };
    });
}
