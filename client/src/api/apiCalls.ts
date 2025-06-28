import ky from "ky";

import type { Course } from "@/types/course";
import type { Exam } from "@/types/exam";
import type { University } from "@/types/university";

export async function getUniversities(): Promise<University[]> {
  return await ky
    .get("http://localhost:8080/api/universities/")
    .json<University[]>();
}

export async function getUniversity(uni: string): Promise<University> {
  return await ky
    .get("http://localhost:8080/api/universities/" + uni)
    .json<University>();
}

export async function addUniversity(uniData: URLSearchParams) {
  return await ky.post("http://localhost:8080/api/universities/", {
    body: uniData,
  });
}

export async function deleteUniversity(uni: string) {
  return await ky.delete("http://localhost:8080/api/universities/" + uni);
}

export async function getCourses(uni: string): Promise<Course[]> {
  return await ky
    .get("http://localhost:8080/api/universities/" + uni + "/courses/")
    .json<Course[]>();
}

export async function getCourse(uni: string, course: string): Promise<Course> {
  return await ky
    .get("http://localhost:8080/api/universities/" + uni + "/courses/" + course)
    .json<Course>();
}

export async function addCourse(uni: string, courseData: URLSearchParams) {
  return await ky.post(
    "http://localhost:8080/api/universities/" + uni + "/courses/",
    { body: courseData },
  );
}

export async function deleteCourse(uni: string, course: string) {
  return await ky.delete(
    "http://localhost:8080/api/universities/" + uni + "/courses/" + course,
  );
}

export async function getExams(uni: string, course: string): Promise<Exam[]> {
  return await ky
    .get(
      "http://localhost:8080/api/universities/" +
        uni +
        "/courses/" +
        course +
        "/exams/",
    )
    .json<Exam[]>();
}

export async function getExam(
  uni: string,
  course: string,
  exam: string,
): Promise<Exam> {
  return await ky
    .get(
      "http://localhost:8080/api/universities/" +
        uni +
        "/courses/" +
        course +
        "/exams/" +
        exam,
    )
    .json<Exam>();
}

export async function addExam(
  uni: string,
  course: string,
  examData: URLSearchParams,
) {
  return await ky.post(
    "http://localhost:8080/api/universities/" +
      uni +
      "/courses/" +
      course +
      "/exams/",
    { body: examData },
  );
}

export async function updateExam(
  uni: string,
  course: string,
  exam: string,
  search_params: URLSearchParams,
) {
  return await ky.put(
    "http://localhost:8080/api/universities/" +
      uni +
      "/courses/" +
      course +
      "/exams/" +
      exam +
      "/update_ects",
    { body: search_params },
  );
}

export async function deleteExam(uni: string, course: string, exam: string) {
  return await ky.delete(
    "http://localhost:8080/api/universities/" +
      uni +
      "/courses/" +
      course +
      "/exams/" +
      exam,
  );
}
