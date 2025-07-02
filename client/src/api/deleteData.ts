import {
  deleteCourse,
  deleteDegreeProgram,
  deleteUniversity,
} from "@/api/apiCalls";

export async function deleteDataUni(university_slug: string) {
  return await deleteUniversity(university_slug)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      console.error("Failed to delete university:", error);
      return { ok: false };
    });
}

export async function deleteDataDegreeProgram(
  university_slug: string,
  degreeProgram_slug: string,
) {
  return await deleteDegreeProgram(university_slug, degreeProgram_slug)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      console.error("Failed to delete degree program:", error);
      return { ok: false };
    });
}

export async function deleteDataCourse(
  university_slug: string,
  degreeProgram_slug: string,
  course_slug: string,
) {
  return await deleteCourse(university_slug, degreeProgram_slug, course_slug)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      console.error("Failed to delete course:", error);
      return { ok: false };
    });
}
