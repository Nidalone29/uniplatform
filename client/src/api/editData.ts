import { updateExam } from "@/api/apiCalls";

export async function editDataExam(
  editData: URLSearchParams,
  university_slug: string,
  course_slug: string,
  exam_slug: string,
) {
  return await updateExam(university_slug, course_slug, exam_slug, editData)
    .then(() => {
      return { ok: true };
    })
    .catch((error) => {
      // TODO handle different errors HTTPError
      console.error("Failed to edit exam:", error);
      return { ok: false };
    });
}
