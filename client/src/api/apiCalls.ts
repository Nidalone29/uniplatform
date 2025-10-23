import ky from "ky";

import type { Course } from "@/types/course";
import type { DegreeProgram } from "@/types/degreeProgram";
import type { University } from "@/types/university";

export async function getUniversities(): Promise<University[]> {
  return await ky
    .get("http://localhost:8080/api/universities/")
    .json<University[]>();
}

export async function getUniversity(university: string): Promise<University> {
  return await ky
    .get("http://localhost:8080/api/universities/" + university)
    .json<University>();
}

export async function addUniversity(uniData: URLSearchParams) {
  return await ky.post("http://localhost:8080/api/universities/", {
    body: uniData,
  });
}

export async function deleteUniversity(university: string) {
  return await ky.delete(
    "http://localhost:8080/api/universities/" + university,
  );
}

export async function getDegreePrograms(
  university: string,
): Promise<DegreeProgram[]> {
  return await ky
    .get(
      "http://localhost:8080/api/universities/" +
        university +
        "/degree-programs/",
    )
    .json<DegreeProgram[]>();
}

export async function getDegreeProgram(
  university: string,
  degreeProgram: string,
): Promise<DegreeProgram> {
  return await ky
    .get(
      "http://localhost:8080/api/universities/" +
        university +
        "/degree-programs/" +
        degreeProgram,
    )
    .json<DegreeProgram>();
}

export async function addDegreeProgram(
  university: string,
  degreeProgramData: URLSearchParams,
) {
  return await ky.post(
    "http://localhost:8080/api/universities/" +
      university +
      "/degree-programs/",
    { body: degreeProgramData },
  );
}

export async function deleteDegreeProgram(
  university: string,
  degreeProgram: string,
) {
  return await ky.delete(
    "http://localhost:8080/api/universities/" +
      university +
      "/degree-programs/" +
      degreeProgram,
  );
}

export async function getCourses(
  university: string,
  degreeProgram: string,
): Promise<Course[]> {
  return await ky
    .get(
      "http://localhost:8080/api/universities/" +
        university +
        "/degree-programs/" +
        degreeProgram +
        "/courses/",
    )
    .json<Course[]>();
}

export async function getCourse(
  university: string,
  degreeProgram: string,
  course: string,
): Promise<Course> {
  return await ky
    .get(
      "http://localhost:8080/api/universities/" +
        university +
        "/degree-programs/" +
        degreeProgram +
        "/courses/" +
        course,
    )
    .json<Course>();
}

export async function addCourse(
  university: string,
  degreeProgram: string,
  courseData: URLSearchParams,
) {
  return await ky.post(
    "http://localhost:8080/api/universities/" +
      university +
      "/degree-programs/" +
      degreeProgram +
      "/courses/",
    { body: courseData },
  );
}

export async function updateCourse(
  university: string,
  degreeProgram: string,
  course: string,
  search_params: URLSearchParams,
) {
  return await ky.put(
    "http://localhost:8080/api/universities/" +
      university +
      "/degree-programs/" +
      degreeProgram +
      "/courses/" +
      course +
      "/update",
    { body: search_params },
  );
}

export async function deleteCourse(
  university: string,
  degreeProgram: string,
  course: string,
) {
  return await ky.delete(
    "http://localhost:8080/api/universities/" +
      university +
      "/degree-programs/" +
      degreeProgram +
      "/courses/" +
      course,
  );
}
