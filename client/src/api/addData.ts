import { addCourse, addExam, addUniversity } from "./apiCalls";

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

export async function addDataCourse(uni_slug: string, data: URLSearchParams) {
  return await addCourse(uni_slug, data)
    .then(() => {
      return { ok: true };
    })
    .catch(error => {
      console.error("Failed to add course:", error);
      return { ok: false };
    });
}
export async function addDataExam(university_slug: string, course_slug: string, searchParams: URLSearchParams,) {
  return await addExam(university_slug, course_slug, searchParams)
    .then(() => {
      return { ok: true };
    })
    .catch(error => {
      console.error("Failed to add exam:", error);
      return { ok: false };
    });
}


