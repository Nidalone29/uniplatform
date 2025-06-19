import ky from "ky";

import type { University } from "@/types/university";
import type { Course } from "@/types/course";
import type { Exam } from "@/types/exam";

export async function getUniversities(): Promise<University[]> {
  return await ky.get("http://localhost:8080/api/universities/").json<University[]>();
}

export async function getUniversity(uni: string): Promise<University> {
  return await ky.get("http://localhost:8080/api/universities/" + uni).json<University>();
}

export async function addUniversity(uniData: URLSearchParams) {
  return await ky.post("http://localhost:8080/api/universities/", { body: uniData });
}

export async function getCourses(uni: string): Promise<Course[]> {
  return await ky.get("http://localhost:8080/api/universities/" + uni + "/courses/").json<Course[]>();
}

export async function getCourse(uni: string, course: string): Promise<Course> {
  return await ky.get("http://localhost:8080/api/universities/" + uni + "/courses/" + course).json<Course>();
}

export async function getExams(uni: string, course: string): Promise<Exam[]> {
  return await ky.get("http://localhost:8080/api/universities/" + uni + "/courses/" + course + "/exams/").json<Exam[]>();
}

export async function getExam(uni: string, course: string, exam: string): Promise<Exam> {
  return await ky.get("http://localhost:8080/api/universities/" + uni + "/courses/" + course + "/exams/" + exam).json<Exam>();
}

export async function updateExam(uni: string, course: string, exam: string, ects: number) {
  const sp = new URLSearchParams();
  sp.set("ects", "" + ects);
  return await ky.put("http://localhost:8080/api/universities/" + uni + "/courses/" + course + "/exams/" + exam + "/update_ects", { searchParams: sp });
}
