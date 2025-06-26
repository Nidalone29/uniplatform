import { deleteCourse, deleteExam, deleteUniversity } from "./apiCalls";

export async function deleteDataUni(university_slug: string) {
  return await deleteUniversity(university_slug)
    .then(() => {
      return { ok: true };
    })
    .catch(error => {
      console.error("Failed to add university:", error);
      return { ok: false };
    });
}

export async function deleteDataCourse(university_slug: string, course_slug: string,) {
  return await deleteCourse(university_slug, course_slug)
    .then(() => {
      return { ok: true };
    })
    .catch(error => {
      console.error("Failed to add course:", error);
      return { ok: false };
    });
}

export async function deleteDataExam(university_slug: string, course_slug: string, exam_slug: string) {
  return await deleteExam(university_slug, course_slug, exam_slug)
    .then(() => {
      return { ok: true };
    })
    .catch(error => {
      console.error("Failed to add exam:", error);
      return { ok: false };
    });
}


