import { addCourse, addDegreeProgram, addUniversity } from "@/api/apiCalls";

export async function addDataUniversity(data: URLSearchParams) {
  return await addUniversity(data)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      console.error("Failed to add university:", error);
      return { ok: false };
    });
}

export async function addDataDegreeProgram(
  university_slug: string,
  data: URLSearchParams,
) {
  return await addDegreeProgram(university_slug, data)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      console.error("Failed to add degree program:", error);
      return { ok: false };
    });
}

export async function addDataCourse(
  university_slug: string,
  degreeProgram_slug: string,
  data: URLSearchParams,
) {
  return await addCourse(university_slug, degreeProgram_slug, data)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      console.error("Failed to add course:", error);
      return { ok: false };
    });
}
