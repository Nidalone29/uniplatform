import {
  getCourse,
  getCourses,
  getExams,
  getUniversities,
  getUniversity,
} from "@/api/apiCalls";

export async function loadDataUni() {
  const fetchedUniversities = await getUniversities().catch((error) => {
    console.error("Failed to fetch universities:", error);
    return [];
  });
  return { universities: fetchedUniversities };
}

export async function loadDataCourse(uniID: string) {
  const fetchedCourses = await getCourses(uniID).catch((error) => {
    console.error("Failed to fetch courses:", error);
    return [];
  });
  const fetchedUniversity = await getUniversity(uniID).catch((error) => {
    console.error("Failed to fetch uni:", error);
    return null;
  });
  return { university: fetchedUniversity, courses: fetchedCourses };
}

export async function loadDataExam(uniID: string, courseID: string) {
  const fetchedExams = await getExams(uniID, courseID).catch((error) => {
    console.error("Failed to fetch exams:", error);
    return [];
  });
  const fetchedCourse = await getCourse(uniID, courseID).catch((error) => {
    console.error("Failed to fetch courses:", error);
    return null;
  });
  const fetchedUniversity = await getUniversity(uniID).catch((error) => {
    console.error("Failed to fetch uni:", error);
    return null;
  });
  return {
    university: fetchedUniversity,
    course: fetchedCourse,
    exams: fetchedExams,
  };
}
