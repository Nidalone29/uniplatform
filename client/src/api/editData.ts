import {
  updateCourse,
  updateDegreeProgram,
  updateUniversity,
} from "@/api/apiCalls";

export async function editUniversity(
  editData: URLSearchParams,
  university_slug: string,
) {
  return await updateUniversity(university_slug, editData)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      // TODO handle different errors HTTPError
      console.error("Failed to edit course:", error);
      return { ok: false };
    });
}

export async function editDataDegreeProgram(
  editData: URLSearchParams,
  university_slug: string,
  degreeProgram_slug: string,
) {
  return await updateDegreeProgram(
    university_slug,
    degreeProgram_slug,
    editData,
  )
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      // TODO handle different errors HTTPError
      console.error("Failed to edit course:", error);
      return { ok: false };
    });
}

export async function editDataCourse(
  editData: URLSearchParams,
  university_slug: string,
  degreeProgram_slug: string,
  course_slug: string,
) {
  return await updateCourse(
    university_slug,
    degreeProgram_slug,
    course_slug,
    editData,
  )
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      // TODO handle different errors HTTPError
      console.error("Failed to edit course:", error);
      return { ok: false };
    });
}
