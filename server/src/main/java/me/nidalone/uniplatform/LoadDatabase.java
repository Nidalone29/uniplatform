package me.nidalone.uniplatform;

import com.neovisionaries.i18n.CountryCode;
import jakarta.transaction.Transactional;
import me.nidalone.uniplatform.domain.entities.Course;
import me.nidalone.uniplatform.domain.entities.DegreeProgram;
import me.nidalone.uniplatform.domain.entities.University;
import me.nidalone.uniplatform.domain.enums.DegreeProgramType;
import me.nidalone.uniplatform.domain.enums.CourseTypeOfExam;
import me.nidalone.uniplatform.domain.enums.CourseAttendance;
import me.nidalone.uniplatform.repositories.UniversityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * The data for the database prepopulation has been generated using an LLM (Gemini 2.5 pro (preview)
 * with Github Copilot)
 */
@Configuration
public class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UniversityRepository universityRepository) {
    return args -> {
      log.info("Preloading data...");

      List<University> universities = new ArrayList<>();

      // University 1
      University unimib = new University("University of Milan-Bicocca", CountryCode.IT, "UNIMIB");
      DegreeProgram cs =
          new DegreeProgram("Computer Science", DegreeProgramType.BACHELOR, 3, unimib);
      cs.setCourses(
          List.of(
              new Course("Analysis I", 12, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, cs),
              new Course(
                  "Programming I", 10, CourseTypeOfExam.WRITTEN, CourseAttendance.ONLINE_SYNC, cs),
              new Course(
                  "Databases", 9, CourseTypeOfExam.WRITTEN, CourseAttendance.ONLINE_ASYNC, cs),
              new Course(
                  "Computer Architecture",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  cs),
              new Course(
                  "Operating Systems", 9, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, cs),
              new Course(
                  "Computer Networks",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  cs),
              new Course(
                  "Software Engineering",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  cs),
              new Course(
                  "Algorithms and Data Structures",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  cs),
              new Course(
                  "Linear Algebra", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, cs),
              new Course(
                  "Probability and Statistics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  cs)));
      DegreeProgram physics = new DegreeProgram("Physics", DegreeProgramType.BACHELOR, 3, unimib);
      physics.setCourses(
          List.of(
              new Course("Mechanics", 12, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, physics),
              new Course(
                  "Electromagnetism",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  physics),
              new Course(
                  "Thermodynamics", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, physics),
              new Course(
                  "Quantum Mechanics",
                  12,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  physics),
              new Course(
                  "Optics", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, physics),
              new Course(
                  "Statistical Mechanics",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physics),
              new Course(
                  "Solid State Physics",
                  7,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  physics),
              new Course(
                  "Nuclear Physics", 6, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, physics),
              new Course(
                  "Astrophysics",
                  7,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  physics),
              new Course(
                  "Computational Physics",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  physics)));
      DegreeProgram biotech =
          new DegreeProgram("Biotechnology", DegreeProgramType.BACHELOR, 3, unimib);
      biotech.setCourses(
          List.of(
              new Course(
                  "General Chemistry",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biotech),
              new Course(
                  "Organic Chemistry",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biotech),
              new Course(
                  "Cell Biology", 8, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, biotech),
              new Course("Genetics", 9, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, biotech),
              new Course(
                  "Biochemistry", 12, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, biotech),
              new Course(
                  "Molecular Biology",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  biotech),
              new Course(
                  "Microbiology", 7, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, biotech),
              new Course(
                  "Immunology", 6, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_SYNC, biotech),
              new Course(
                  "Plant Biotechnology",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  biotech),
              new Course(
                  "Industrial Biotechnology",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  biotech)));
      DegreeProgram economics =
          new DegreeProgram("Economics", DegreeProgramType.BACHELOR, 3, unimib);
      economics.setCourses(
          List.of(
              new Course(
                  "Microeconomics",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economics),
              new Course(
                  "Macroeconomics",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economics),
              new Course(
                  "Econometrics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economics),
              new Course(
                  "Mathematical Economics",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economics),
              new Course(
                  "International Economics",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  economics),
              new Course(
                  "Public Economics",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  economics),
              new Course(
                  "Corporate Finance",
                  7,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  economics),
              new Course(
                  "History of Economic Thought",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  economics),
              new Course(
                  "Development Economics",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  economics),
              new Course(
                  "Behavioral Economics",
                  7,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  economics)));
      DegreeProgram dataScience =
          new DegreeProgram("Data Science", DegreeProgramType.MASTER_I, 2, unimib);
      dataScience.setCourses(
          List.of(
              new Course(
                  "Machine Learning",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  dataScience),
              new Course(
                  "Big Data Analytics",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  dataScience),
              new Course(
                  "Statistical Methods for Data Science",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  dataScience),
              new Course(
                  "Data Visualization",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  dataScience),
              new Course(
                  "Deep Learning",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  dataScience),
              new Course(
                  "Natural Language Processing",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  dataScience),
              new Course(
                  "Cloud Computing",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  dataScience),
              new Course(
                  "Data Ethics and Privacy",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  dataScience),
              new Course(
                  "Reinforcement Learning",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  dataScience),
              new Course(
                  "Time Series Analysis",
                  7,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  dataScience)));
      DegreeProgram psychologyUnimib =
          new DegreeProgram("Psychology", DegreeProgramType.BACHELOR, 3, unimib);
      psychologyUnimib.setCourses(
          List.of(
              new Course(
                  "General Psychology",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychologyUnimib),
              new Course(
                  "Social Psychology",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  psychologyUnimib),
              new Course(
                  "Developmental Psychology",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychologyUnimib),
              new Course(
                  "Cognitive Psychology",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychologyUnimib),
              new Course(
                  "Psychometrics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  psychologyUnimib),
              new Course(
                  "Dynamic Psychology",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  psychologyUnimib),
              new Course(
                  "Neuroscience",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychologyUnimib),
              new Course(
                  "Clinical Psychology",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  psychologyUnimib),
              new Course(
                  "Work and Organizational Psychology",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  psychologyUnimib),
              new Course(
                  "English for Psychology",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  psychologyUnimib)));
      unimib.setDegreePrograms(
          List.of(cs, physics, biotech, economics, dataScience, psychologyUnimib));
      universities.add(unimib);

      // University 2
      University eth = new University("ETH Zurich", CountryCode.CH, "ETHZ");
      DegreeProgram ee =
          new DegreeProgram("Electrical Engineering", DegreeProgramType.MASTER_I, 2, eth);
      ee.setCourses(
          List.of(
              new Course(
                  "Control Systems", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, ee),
              new Course(
                  "Power Electronics",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  ee),
              new Course(
                  "Digital Signal Processing",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  ee),
              new Course(
                  "Communication Systems",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  ee),
              new Course("VLSI Design", 7, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, ee),
              new Course("Photonics", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, ee),
              new Course(
                  "Renewable Energy Systems",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  ee),
              new Course(
                  "Biomedical Imaging",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  ee),
              new Course(
                  "Machine Learning for Engineering",
                  7,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  ee),
              new Course(
                  "Advanced Robotics", 6, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, ee)));
      DegreeProgram me =
          new DegreeProgram("Mechanical Engineering", DegreeProgramType.BACHELOR, 3, eth);
      me.setCourses(
          List.of(
              new Course(
                  "Thermodynamics", 10, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, me),
              new Course(
                  "Fluid Dynamics", 8, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_SYNC, me),
              new Course(
                  "Statics and Dynamics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  me),
              new Course(
                  "Mechanics of Materials",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  me),
              new Course(
                  "Manufacturing Technology",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  me),
              new Course(
                  "Machine Design", 8, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, me),
              new Course(
                  "Heat Transfer", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, me),
              new Course(
                  "Control Systems", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ONLINE_SYNC, me),
              new Course(
                  "Finite Element Methods",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  me),
              new Course(
                  "Mechatronics", 6, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, me)));
      DegreeProgram arch = new DegreeProgram("Architecture", DegreeProgramType.BACHELOR, 3, eth);
      arch.setCourses(
          List.of(
              new Course(
                  "Architectural Design I",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  arch),
              new Course(
                  "History of Art and Architecture",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  arch),
              new Course(
                  "Building Materials",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  arch),
              new Course(
                  "Structural Design", 9, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, arch),
              new Course(
                  "Urban Planning",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  arch),
              new Course(
                  "Digital Fabrication",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  arch),
              new Course(
                  "Landscape Architecture",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  arch),
              new Course(
                  "Architectural Theory",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  arch),
              new Course(
                  "Sustainable Building",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  arch),
              new Course(
                  "Professional Practice",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  arch)));
      DegreeProgram envSci =
          new DegreeProgram("Environmental Sciences", DegreeProgramType.MASTER_I, 2, eth);
      envSci.setCourses(
          List.of(
              new Course(
                  "Ecology and Evolution",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  envSci),
              new Course(
                  "Atmospheric Chemistry",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  envSci),
              new Course(
                  "Hydrology", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ONLINE_SYNC, envSci),
              new Course(
                  "Environmental Policy",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  envSci),
              new Course(
                  "Climate Systems", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, envSci),
              new Course(
                  "Soil Science", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, envSci),
              new Course(
                  "Geographic Information Systems (GIS)",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  envSci),
              new Course(
                  "Environmental Risk Assessment",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  envSci),
              new Course(
                  "Conservation Biology",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  envSci),
              new Course(
                  "Water Resources Management",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  envSci)));
      DegreeProgram materialsScience =
          new DegreeProgram("Materials Science", DegreeProgramType.MASTER_I, 2, eth);
      materialsScience.setCourses(
          List.of(
              new Course(
                  "Thermodynamics of Materials",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  materialsScience),
              new Course(
                  "Kinetics of Materials",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  materialsScience),
              new Course(
                  "Mechanical Properties of Materials",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  materialsScience),
              new Course(
                  "Electronic Properties of Materials",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  materialsScience),
              new Course(
                  "Soft Materials",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  materialsScience),
              new Course(
                  "Biomaterials",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  materialsScience),
              new Course(
                  "Computational Materials Science",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  materialsScience),
              new Course(
                  "Materials Characterization",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  materialsScience),
              new Course(
                  "Surface Engineering",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  materialsScience),
              new Course(
                  "Advanced Functional Materials",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  materialsScience)));
      eth.setDegreePrograms(List.of(ee, me, arch, envSci, materialsScience));
      universities.add(eth);

      // University 3
      University tum = new University("Technical University of Munich", CountryCode.DE, "TUM");
      DegreeProgram informatics =
          new DegreeProgram("Informatics", DegreeProgramType.BACHELOR, 3, tum);
      informatics.setCourses(
          List.of(
              new Course(
                  "Introduction to Algorithms",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informatics),
              new Course(
                  "Software Engineering",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  informatics),
              new Course(
                  "Discrete Structures",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informatics),
              new Course(
                  "Functional Programming",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  informatics),
              new Course(
                  "Computer Architecture",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informatics),
              new Course(
                  "Operating Systems",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  informatics),
              new Course(
                  "Databases",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  informatics),
              new Course(
                  "Compiler Construction",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  informatics),
              new Course(
                  "Formal Languages and Automata",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informatics),
              new Course(
                  "Artificial Intelligence",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  informatics)));
      DegreeProgram math = new DegreeProgram("Mathematics", DegreeProgramType.MASTER_II, 2, tum);
      math.setCourses(
          List.of(
              new Course("Topology", 9, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, math),
              new Course(
                  "Number Theory", 9, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_SYNC, math),
              new Course(
                  "Algebraic Geometry", 9, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, math),
              new Course(
                  "Differential Geometry",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  math),
              new Course(
                  "Functional Analysis",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  math),
              new Course(
                  "Partial Differential Equations",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  math),
              new Course(
                  "Stochastic Processes",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  math),
              new Course(
                  "Numerical Analysis",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  math),
              new Course(
                  "Mathematical Finance",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  math),
              new Course(
                  "Optimization", 9, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, math)));
      DegreeProgram aerospace =
          new DegreeProgram("Aerospace Engineering", DegreeProgramType.BACHELOR, 3, tum);
      aerospace.setCourses(
          List.of(
              new Course(
                  "Aerodynamics", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, aerospace),
              new Course(
                  "Flight Mechanics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  aerospace),
              new Course(
                  "Propulsion Systems",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  aerospace),
              new Course(
                  "Spacecraft Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  aerospace),
              new Course(
                  "Aircraft Structures",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  aerospace),
              new Course(
                  "Control Systems",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  aerospace),
              new Course(
                  "Materials for Aerospace",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  aerospace),
              new Course(
                  "Orbital Mechanics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  aerospace),
              new Course(
                  "Avionics", 6, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, aerospace),
              new Course(
                  "Helicopter Technology",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  aerospace)));
      DegreeProgram management =
          new DegreeProgram("Management and Technology", DegreeProgramType.BACHELOR, 3, tum);
      management.setCourses(
          List.of(
              new Course(
                  "Business Administration",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  management),
              new Course(
                  "Accounting", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, management),
              new Course(
                  "Marketing",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  management),
              new Course(
                  "Innovation Management",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  management),
              new Course(
                  "Corporate Finance",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  management),
              new Course(
                  "Supply Chain Management",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  management),
              new Course(
                  "Entrepreneurship",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  management),
              new Course(
                  "Technology and Innovation Strategy",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  management),
              new Course(
                  "Economics I", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, management),
              new Course(
                  "Law for Managers",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  management)));
      DegreeProgram physicsTUM =
          new DegreeProgram(
              "Physics (Applied and Engineering)", DegreeProgramType.MASTER_I, 2, tum);
      physicsTUM.setCourses(
          List.of(
              new Course(
                  "Advanced Solid State Physics",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsTUM),
              new Course(
                  "Biophysics", 9, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_SYNC, physicsTUM),
              new Course(
                  "Particle Physics",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsTUM),
              new Course(
                  "Plasma Physics",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsTUM),
              new Course(
                  "Medical Physics",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  physicsTUM),
              new Course(
                  "Semiconductor Physics",
                  9,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  physicsTUM),
              new Course(
                  "Computational Physics",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  physicsTUM),
              new Course(
                  "Quantum Optics", 9, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, physicsTUM),
              new Course(
                  "Renewable Energy Physics",
                  9,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  physicsTUM),
              new Course(
                  "Advanced Laboratory Course",
                  12,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  physicsTUM)));
      tum.setDegreePrograms(List.of(informatics, math, aerospace, management, physicsTUM));
      universities.add(tum);

      // University 4
      University sorbonne = new University("Sorbonne University", CountryCode.FR, "SORBONNE");
      DegreeProgram history = new DegreeProgram("History", DegreeProgramType.BACHELOR, 3, sorbonne);
      history.setCourses(
          List.of(
              new Course(
                  "Ancient History",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  history),
              new Course(
                  "Medieval History",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  history),
              new Course(
                  "Modern History", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, history),
              new Course(
                  "Contemporary History",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  history),
              new Course(
                  "History of France", 6, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, history),
              new Course(
                  "History of Art",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  history),
              new Course(
                  "Methodology of History",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  history),
              new Course(
                  "Economic History",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  history),
              new Course(
                  "Political History",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  history),
              new Course(
                  "Cultural History",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  history)));
      DegreeProgram philosophy =
          new DegreeProgram("Philosophy", DegreeProgramType.DOCTORAL, 3, sorbonne);
      philosophy.setCourses(
          List.of(
              new Course(
                  "Metaphysics",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  philosophy),
              new Course(
                  "Epistemology",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  philosophy),
              new Course("Ethics", 10, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, philosophy),
              new Course(
                  "Political Philosophy",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophy),
              new Course(
                  "Aesthetics",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  philosophy),
              new Course(
                  "History of Philosophy",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  philosophy),
              new Course(
                  "Logic", 10, CourseTypeOfExam.WRITTEN, CourseAttendance.ONLINE_ASYNC, philosophy),
              new Course(
                  "Philosophy of Science",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  philosophy),
              new Course(
                  "Phenomenology", 10, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, philosophy),
              new Course(
                  "Research Seminar",
                  20,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  philosophy)));
      DegreeProgram literature =
          new DegreeProgram("Literature", DegreeProgramType.BACHELOR, 3, sorbonne);
      literature.setCourses(
          List.of(
              new Course(
                  "French Literature",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  literature),
              new Course(
                  "Comparative Literature",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  literature),
              new Course(
                  "Literary Theory",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  literature),
              new Course(
                  "Latin", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, literature),
              new Course(
                  "Ancient Greek",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  literature),
              new Course(
                  "Poetry Analysis",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  literature),
              new Course(
                  "Narrative Analysis",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  literature),
              new Course(
                  "Theater Studies",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  literature),
              new Course(
                  "World Literature",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  literature),
              new Course(
                  "Creative Writing",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  literature)));
      DegreeProgram earthSci =
          new DegreeProgram("Earth Sciences", DegreeProgramType.MASTER_I, 2, sorbonne);
      earthSci.setCourses(
          List.of(
              new Course(
                  "Geophysics", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, earthSci),
              new Course(
                  "Geochemistry", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, earthSci),
              new Course(
                  "Petrology", 8, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, earthSci),
              new Course(
                  "Sedimentology",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  earthSci),
              new Course(
                  "Structural Geology",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  earthSci),
              new Course(
                  "Paleontology", 6, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_SYNC, earthSci),
              new Course(
                  "Oceanography",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  earthSci),
              new Course(
                  "Climatology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  earthSci),
              new Course(
                  "Remote Sensing",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  earthSci),
              new Course(
                  "Field Geology",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  earthSci)));
      DegreeProgram chemistry =
          new DegreeProgram("Chemistry", DegreeProgramType.BACHELOR, 3, sorbonne);
      chemistry.setCourses(
          List.of(
              new Course(
                  "Inorganic Chemistry",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chemistry),
              new Course(
                  "Organic Chemistry",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chemistry),
              new Course(
                  "Physical Chemistry",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chemistry),
              new Course(
                  "Analytical Chemistry",
                  9,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  chemistry),
              new Course(
                  "Polymer Chemistry",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  chemistry),
              new Course(
                  "Materials Chemistry",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  chemistry),
              new Course(
                  "Quantum Chemistry",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chemistry),
              new Course(
                  "Spectroscopy",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  chemistry),
              new Course(
                  "Environmental Chemistry",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  chemistry),
              new Course(
                  "Biochemistry",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chemistry)));
      sorbonne.setDegreePrograms(List.of(history, philosophy, literature, earthSci, chemistry));
      universities.add(sorbonne);

      // University 5
      University cambridge = new University("University of Cambridge", CountryCode.GB, "CAM");
      DegreeProgram natsci =
          new DegreeProgram("Natural Sciences", DegreeProgramType.BACHELOR, 3, cambridge);
      natsci.setCourses(
          List.of(
              new Course(
                  "Biology of Cells",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  natsci),
              new Course(
                  "Chemistry", 15, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, natsci),
              new Course("Physics", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, natsci),
              new Course(
                  "Materials Science",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  natsci),
              new Course(
                  "Earth Sciences",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  natsci),
              new Course(
                  "Evolution and Behaviour",
                  12,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  natsci),
              new Course(
                  "Physiology of Organisms",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  natsci),
              new Course(
                  "Mathematical Biology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  natsci),
              new Course(
                  "History and Philosophy of Science",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  natsci),
              new Course(
                  "Advanced Genetics",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  natsci)));
      DegreeProgram law = new DegreeProgram("Law", DegreeProgramType.BACHELOR, 3, cambridge);
      law.setCourses(
          List.of(
              new Course(
                  "Criminal Law", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, law),
              new Course(
                  "Contract Law", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, law),
              new Course(
                  "Constitutional Law",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  law),
              new Course(
                  "Law of Tort", 12, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, law),
              new Course("Land Law", 12, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, law),
              new Course("Equity", 10, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, law),
              new Course(
                  "European Union Law",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  law),
              new Course(
                  "Jurisprudence", 10, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_ASYNC, law),
              new Course(
                  "International Law",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  law),
              new Course(
                  "Company Law",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  law)));
      DegreeProgram classics =
          new DegreeProgram("Classics", DegreeProgramType.BACHELOR, 3, cambridge);
      classics.setCourses(
          List.of(
              new Course(
                  "Greek Language",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  classics),
              new Course(
                  "Latin Language",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  classics),
              new Course(
                  "Greek Literature",
                  12,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  classics),
              new Course(
                  "Roman Literature",
                  12,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  classics),
              new Course(
                  "Greek History",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  classics),
              new Course(
                  "Roman History",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  classics),
              new Course(
                  "Ancient Philosophy",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  classics),
              new Course(
                  "Classical Art and Archaeology",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  classics),
              new Course(
                  "Philology and Linguistics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  classics),
              new Course(
                  "Reception of the Classical World",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  classics)));
      DegreeProgram engineering =
          new DegreeProgram("Engineering", DegreeProgramType.MASTER_I, 2, cambridge);
      engineering.setCourses(
          List.of(
              new Course(
                  "Mechanical Engineering",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineering),
              new Course(
                  "Aerospace and Aerothermal Engineering",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineering),
              new Course(
                  "Bioengineering",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineering),
              new Course(
                  "Civil, Structural and Environmental Engineering",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineering),
              new Course(
                  "Electrical and Electronic Engineering",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineering),
              new Course(
                  "Information and Computer Engineering",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  engineering),
              new Course(
                  "Energy, Sustainability and the Environment",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  engineering),
              new Course(
                  "Instrumentation and Control",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  engineering),
              new Course(
                  "Management of Technology",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  engineering),
              new Course(
                  "Nuclear Engineering",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineering)));
      DegreeProgram mathematics =
          new DegreeProgram("Mathematics", DegreeProgramType.BACHELOR, 3, cambridge);
      mathematics.setCourses(
          List.of(
              new Course(
                  "Numbers and Sets",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  mathematics),
              new Course(
                  "Groups", 12, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, mathematics),
              new Course(
                  "Vectors and Matrices",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  mathematics),
              new Course(
                  "Analysis I",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  mathematics),
              new Course(
                  "Differential Equations",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  mathematics),
              new Course(
                  "Probability",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  mathematics),
              new Course(
                  "Dynamics and Relativity",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  mathematics),
              new Course(
                  "Vector Calculus",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  mathematics),
              new Course(
                  "Quantum Mechanics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  mathematics),
              new Course(
                  "Statistics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  mathematics)));
      cambridge.setDegreePrograms(List.of(natsci, law, classics, engineering, mathematics));
      universities.add(cambridge);

      // University 6
      University harvard = new University("Harvard University", CountryCode.US, "HARVARD");
      DegreeProgram economics2 =
          new DegreeProgram("Economics", DegreeProgramType.BACHELOR, 4, harvard);
      economics2.setCourses(
          List.of(
              new Course(
                  "Microeconomics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economics2),
              new Course(
                  "Macroeconomics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economics2),
              new Course(
                  "Econometrics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economics2),
              new Course(
                  "Game Theory", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, economics2),
              new Course(
                  "Industrial Organization",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  economics2),
              new Course(
                  "Labor Economics",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  economics2),
              new Course(
                  "Financial Economics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economics2),
              new Course(
                  "International Trade",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economics2),
              new Course(
                  "Public Finance", 8, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, economics2),
              new Course(
                  "Economic Development",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  economics2)));
      DegreeProgram polisci =
          new DegreeProgram("Political Science", DegreeProgramType.MASTER_I, 2, harvard);
      polisci.setCourses(
          List.of(
              new Course(
                  "International Relations",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  polisci),
              new Course(
                  "Comparative Politics",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  polisci),
              new Course(
                  "American Politics",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  polisci),
              new Course(
                  "Political Theory", 10, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, polisci),
              new Course(
                  "Quantitative Methods for Political Science",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  polisci),
              new Course(
                  "Qualitative Methods",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  polisci),
              new Course(
                  "International Security",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  polisci),
              new Course(
                  "Political Economy",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  polisci),
              new Course(
                  "Public Policy Analysis",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  polisci),
              new Course(
                  "Human Rights",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  polisci)));
      DegreeProgram csHarvard =
          new DegreeProgram("Computer Science", DegreeProgramType.BACHELOR, 4, harvard);
      csHarvard.setCourses(
          List.of(
              new Course(
                  "Introduction to Computer Science",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csHarvard),
              new Course(
                  "Data Structures and Algorithms",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csHarvard),
              new Course(
                  "Systems Programming",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csHarvard),
              new Course(
                  "Theory of Computation",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csHarvard),
              new Course(
                  "Artificial Intelligence",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  csHarvard),
              new Course(
                  "Machine Learning",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  csHarvard),
              new Course(
                  "Computer Graphics",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csHarvard),
              new Course(
                  "Cryptography",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  csHarvard),
              new Course(
                  "Computer Networks",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  csHarvard),
              new Course(
                  "Database Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csHarvard)));
      DegreeProgram medicineHarvard =
          new DegreeProgram("Medicine", DegreeProgramType.DOCTORAL, 4, harvard);
      medicineHarvard.setCourses(
          List.of(
              new Course(
                  "Anatomy",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Physiology",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Biochemistry",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Pharmacology",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Pathology",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Microbiology",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Immunology",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Clinical Skills",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineHarvard),
              new Course(
                  "Medical Ethics",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  medicineHarvard),
              new Course(
                  "Epidemiology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  medicineHarvard)));
      DegreeProgram psychologyHarvard =
          new DegreeProgram("Psychology", DegreeProgramType.BACHELOR, 4, harvard);
      psychologyHarvard.setCourses(
          List.of(
              new Course(
                  "Introduction to Psychology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychologyHarvard),
              new Course(
                  "Cognitive Neuroscience",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychologyHarvard),
              new Course(
                  "Social Psychology",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  psychologyHarvard),
              new Course(
                  "Developmental Psychology",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  psychologyHarvard),
              new Course(
                  "Abnormal Psychology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychologyHarvard),
              new Course(
                  "Behavioral Genetics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  psychologyHarvard),
              new Course(
                  "The Social Brain",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  psychologyHarvard),
              new Course(
                  "Clinical Psychology",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  psychologyHarvard),
              new Course(
                  "Cultural Psychology",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  psychologyHarvard),
              new Course(
                  "Research Methods in Psychology",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  psychologyHarvard)));
      harvard.setDegreePrograms(
          List.of(economics2, polisci, csHarvard, medicineHarvard, psychologyHarvard));
      universities.add(harvard);

      // University 7
      University tokyo = new University("University of Tokyo", CountryCode.JP, "UTOKYO");
      DegreeProgram engineeringTokyo =
          new DegreeProgram("Engineering", DegreeProgramType.BACHELOR, 4, tokyo);
      engineeringTokyo.setCourses(
          List.of(
              new Course(
                  "Materials Science",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo),
              new Course(
                  "Robotics",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  engineeringTokyo),
              new Course(
                  "Applied Mechanics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo),
              new Course(
                  "Thermodynamics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo),
              new Course(
                  "Fluid Mechanics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo),
              new Course(
                  "Electrical Circuits",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo),
              new Course(
                  "Information and Communication Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  engineeringTokyo),
              new Course(
                  "Chemical Engineering",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo),
              new Course(
                  "Civil Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo),
              new Course(
                  "Architecture",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringTokyo)));
      DegreeProgram medicineTokyo =
          new DegreeProgram("Medicine", DegreeProgramType.SINGLE_CYCLE_MASTER, 6, tokyo);
      medicineTokyo.setCourses(
          List.of(
              new Course(
                  "Anatomy",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineTokyo),
              new Course(
                  "Physiology", 20, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, medicineTokyo),
              new Course(
                  "Biochemistry",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineTokyo),
              new Course(
                  "Pharmacology",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineTokyo),
              new Course(
                  "Pathology",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineTokyo),
              new Course(
                  "Microbiology",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineTokyo),
              new Course(
                  "Immunology", 15, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, medicineTokyo),
              new Course(
                  "Internal Medicine",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineTokyo),
              new Course(
                  "Surgery",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineTokyo),
              new Course(
                  "Pediatrics",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineTokyo)));
      DegreeProgram lawTokyo = new DegreeProgram("Law", DegreeProgramType.BACHELOR, 4, tokyo);
      lawTokyo.setCourses(
          List.of(
              new Course(
                  "Constitutional Law",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTokyo),
              new Course(
                  "Civil Law", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawTokyo),
              new Course(
                  "Criminal Law", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawTokyo),
              new Course(
                  "Commercial Law",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTokyo),
              new Course(
                  "Administrative Law",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTokyo),
              new Course(
                  "International Law",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  lawTokyo),
              new Course(
                  "Legal Philosophy",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  lawTokyo),
              new Course(
                  "Political Science",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTokyo),
              new Course(
                  "Economic Law",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  lawTokyo),
              new Course(
                  "Labor Law",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  lawTokyo)));
      DegreeProgram agriculture =
          new DegreeProgram("Agriculture", DegreeProgramType.BACHELOR, 4, tokyo);
      agriculture.setCourses(
          List.of(
              new Course(
                  "Agricultural and Resource Economics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  agriculture),
              new Course(
                  "Applied Biological Chemistry",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  agriculture),
              new Course(
                  "Forest Science",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  agriculture),
              new Course(
                  "Fisheries Science",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  agriculture),
              new Course(
                  "Animal Science",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  agriculture),
              new Course(
                  "Soil Science",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  agriculture),
              new Course(
                  "Plant Pathology",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  agriculture),
              new Course(
                  "Food Science and Technology",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  agriculture),
              new Course(
                  "Environmental Science",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  agriculture),
              new Course(
                  "International Development",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  agriculture)));
      DegreeProgram economicsTokyo =
          new DegreeProgram("Economics", DegreeProgramType.BACHELOR, 4, tokyo);
      economicsTokyo.setCourses(
          List.of(
              new Course(
                  "Microeconomics I",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTokyo),
              new Course(
                  "Macroeconomics I",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTokyo),
              new Course(
                  "Statistics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTokyo),
              new Course(
                  "Econometrics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economicsTokyo),
              new Course(
                  "History of Japanese Economy",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  economicsTokyo),
              new Course(
                  "Public Finance",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsTokyo),
              new Course(
                  "International Finance",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economicsTokyo),
              new Course(
                  "Game Theory",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  economicsTokyo),
              new Course(
                  "Labor Economics",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsTokyo),
              new Course(
                  "Seminar in Economics",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  economicsTokyo)));
      tokyo.setDegreePrograms(
          List.of(engineeringTokyo, medicineTokyo, lawTokyo, agriculture, economicsTokyo));
      universities.add(tokyo);

      // University 8
      University peking = new University("Peking University", CountryCode.CN, "PKU");
      DegreeProgram chinese =
          new DegreeProgram(
              "Chinese Language and Literature", DegreeProgramType.BACHELOR, 4, peking);
      chinese.setCourses(
          List.of(
              new Course(
                  "Modern Chinese",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chinese),
              new Course(
                  "Classical Chinese",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chinese),
              new Course(
                  "Chinese Linguistics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  chinese),
              new Course(
                  "Ancient Chinese Literature",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  chinese),
              new Course(
                  "Modern Chinese Literature",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  chinese),
              new Course(
                  "Contemporary Chinese Literature",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  chinese),
              new Course(
                  "Comparative Literature",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  chinese),
              new Course(
                  "Literary Theory",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  chinese),
              new Course(
                  "Chinese Folk Literature",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  chinese),
              new Course(
                  "Creative Writing in Chinese",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  chinese)));
      DegreeProgram business =
          new DegreeProgram("Business Administration", DegreeProgramType.MASTER_I, 2, peking);
      business.setCourses(
          List.of(
              new Course(
                  "Marketing Management",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  business),
              new Course(
                  "Financial Management",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  business),
              new Course(
                  "Strategic Management",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  business),
              new Course(
                  "Operations Management",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  business),
              new Course(
                  "Human Resource Management",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  business),
              new Course(
                  "Managerial Economics",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  business),
              new Course(
                  "Accounting", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, business),
              new Course(
                  "Organizational Behavior",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  business),
              new Course(
                  "International Business",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  business),
              new Course(
                  "Business Ethics",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  business)));
      DegreeProgram physicsPeking =
          new DegreeProgram("Physics", DegreeProgramType.BACHELOR, 4, peking);
      physicsPeking.setCourses(
          List.of(
              new Course(
                  "General Physics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsPeking),
              new Course(
                  "Theoretical Mechanics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsPeking),
              new Course(
                  "Electrodynamics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsPeking),
              new Course(
                  "Quantum Mechanics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsPeking),
              new Course(
                  "Thermodynamics and Statistical Physics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsPeking),
              new Course(
                  "Solid State Physics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsPeking),
              new Course(
                  "Nuclear and Particle Physics",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  physicsPeking),
              new Course(
                  "Optics",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  physicsPeking),
              new Course(
                  "Computational Physics",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  physicsPeking),
              new Course(
                  "Astrophysics",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  physicsPeking)));
      DegreeProgram internationalRelations =
          new DegreeProgram("International Relations", DegreeProgramType.MASTER_I, 2, peking);
      internationalRelations.setCourses(
          List.of(
              new Course(
                  "Theories of International Relations",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  internationalRelations),
              new Course(
                  "Chinese Foreign Policy",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  internationalRelations),
              new Course(
                  "International Political Economy",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  internationalRelations),
              new Course(
                  "Global Governance",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  internationalRelations),
              new Course(
                  "International Security Studies",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  internationalRelations),
              new Course(
                  "Public International Law",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  internationalRelations),
              new Course(
                  "Area Studies: East Asia",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  internationalRelations),
              new Course(
                  "Diplomacy",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  internationalRelations),
              new Course(
                  "Conflict Resolution",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  internationalRelations),
              new Course(
                  "Research Methods in IR",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  internationalRelations)));
      DegreeProgram computerSciencePeking =
          new DegreeProgram("Computer Science", DegreeProgramType.BACHELOR, 4, peking);
      computerSciencePeking.setCourses(
          List.of(
              new Course(
                  "Introduction to Computer Science",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  computerSciencePeking),
              new Course(
                  "Data Structures",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  computerSciencePeking),
              new Course(
                  "Algorithms",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  computerSciencePeking),
              new Course(
                  "Computer Architecture",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  computerSciencePeking),
              new Course(
                  "Operating Systems",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  computerSciencePeking),
              new Course(
                  "Compiler Principles",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  computerSciencePeking),
              new Course(
                  "Software Engineering",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  computerSciencePeking),
              new Course(
                  "Database Systems",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  computerSciencePeking),
              new Course(
                  "Artificial Intelligence",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  computerSciencePeking),
              new Course(
                  "Computer Networks",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  computerSciencePeking)));
      peking.setDegreePrograms(
          List.of(chinese, business, physicsPeking, internationalRelations, computerSciencePeking));
      universities.add(peking);

      // University 9
      University toronto = new University("University of Toronto", CountryCode.CA, "UTORONTO");
      DegreeProgram psychology =
          new DegreeProgram("Psychology", DegreeProgramType.BACHELOR, 4, toronto);
      psychology.setCourses(
          List.of(
              new Course(
                  "Introduction to Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  psychology),
              new Course(
                  "Social Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  psychology),
              new Course(
                  "Cognitive Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychology),
              new Course(
                  "Developmental Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychology),
              new Course(
                  "Abnormal Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychology),
              new Course(
                  "Neuroscience",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  psychology),
              new Course(
                  "Perception",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  psychology),
              new Course(
                  "Learning and Memory",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  psychology),
              new Course(
                  "Research Methods in Psychology",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  psychology),
              new Course(
                  "Statistics for Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  psychology)));
      DegreeProgram compeng =
          new DegreeProgram("Computer Engineering", DegreeProgramType.BACHELOR, 4, toronto);
      compeng.setCourses(
          List.of(
              new Course(
                  "Digital Logic Design",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  compeng),
              new Course(
                  "Computer Architecture",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  compeng),
              new Course(
                  "Programming Fundamentals",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  compeng),
              new Course(
                  "Algorithms and Data Structures",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  compeng),
              new Course(
                  "Software Design",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  compeng),
              new Course(
                  "Operating Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  compeng),
              new Course(
                  "Computer Networks",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  compeng),
              new Course(
                  "Embedded Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  compeng),
              new Course(
                  "Control Systems",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  compeng),
              new Course(
                  "VLSI Systems", 8, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, compeng)));
      DegreeProgram lifeSci =
          new DegreeProgram("Life Sciences", DegreeProgramType.BACHELOR, 4, toronto);
      lifeSci.setCourses(
          List.of(
              new Course(
                  "Cell and Molecular Biology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lifeSci),
              new Course(
                  "Genetics", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lifeSci),
              new Course(
                  "Biochemistry", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lifeSci),
              new Course(
                  "Physiology", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, lifeSci),
              new Course(
                  "Ecology and Evolutionary Biology",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  lifeSci),
              new Course(
                  "Immunology", 6, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_SYNC, lifeSci),
              new Course(
                  "Microbiology", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, lifeSci),
              new Course(
                  "Pharmacology and Toxicology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  lifeSci),
              new Course(
                  "Human Biology", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lifeSci),
              new Course(
                  "Research Project in Life Sciences",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  lifeSci)));
      DegreeProgram publicPolicy =
          new DegreeProgram("Public Policy", DegreeProgramType.MASTER_I, 2, toronto);
      publicPolicy.setCourses(
          List.of(
              new Course(
                  "Public Policy Process",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  publicPolicy),
              new Course(
                  "Economic Analysis for Public Policy",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  publicPolicy),
              new Course(
                  "Quantitative Methods for Policy Analysis",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  publicPolicy),
              new Course(
                  "Qualitative Methods for Policy Analysis",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  publicPolicy),
              new Course(
                  "Public Management",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  publicPolicy),
              new Course(
                  "Ethics and Public Service",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  publicPolicy),
              new Course(
                  "Social Policy",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  publicPolicy),
              new Course(
                  "Health Policy",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  publicPolicy),
              new Course(
                  "Environmental Policy",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  publicPolicy),
              new Course(
                  "Policy Internship",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  publicPolicy)));
      DegreeProgram economicsToronto =
          new DegreeProgram("Economics", DegreeProgramType.BACHELOR, 4, toronto);
      economicsToronto.setCourses(
          List.of(
              new Course(
                  "Microeconomic Theory",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsToronto),
              new Course(
                  "Macroeconomic Theory",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsToronto),
              new Course(
                  "Quantitative Methods in Economics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsToronto),
              new Course(
                  "Econometrics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economicsToronto),
              new Course(
                  "International Economics",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  economicsToronto),
              new Course(
                  "Development Economics",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsToronto),
              new Course(
                  "Industrial Organization",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  economicsToronto),
              new Course(
                  "Labor Economics",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  economicsToronto),
              new Course(
                  "Public Economics",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  economicsToronto),
              new Course(
                  "Financial Economics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsToronto)));
      toronto.setDegreePrograms(
          List.of(psychology, compeng, lifeSci, publicPolicy, economicsToronto));
      universities.add(toronto);

      // University 10
      University nus = new University("National University of Singapore", CountryCode.SG, "NUS");
      DegreeProgram computing = new DegreeProgram("Computing", DegreeProgramType.BACHELOR, 4, nus);
      computing.setCourses(
          List.of(
              new Course(
                  "Data Structures and Algorithms",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  computing),
              new Course(
                  "Discrete Mathematics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  computing),
              new Course(
                  "Programming Methodology",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  computing),
              new Course(
                  "Computer Organization",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  computing),
              new Course(
                  "Operating Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  computing),
              new Course(
                  "Software Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  computing),
              new Course(
                  "Artificial Intelligence",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  computing),
              new Course(
                  "Computer Networks",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  computing),
              new Course(
                  "Database Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  computing),
              new Course(
                  "Information Security",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  computing)));
      DegreeProgram architecture =
          new DegreeProgram("Architecture", DegreeProgramType.MASTER_I, 2, nus);
      architecture.setCourses(
          List.of(
              new Course(
                  "Architectural Design",
                  20,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  architecture),
              new Course(
                  "History of Architecture",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  architecture),
              new Course(
                  "Urban Studies",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  architecture),
              new Course(
                  "Building Technology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  architecture),
              new Course(
                  "Environmental Systems",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  architecture),
              new Course(
                  "Digital Design and Fabrication",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  architecture),
              new Course(
                  "Architectural Practice",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  architecture),
              new Course(
                  "Landscape Architecture",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  architecture),
              new Course(
                  "Tropical Architecture",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  architecture),
              new Course(
                  "Dissertation",
                  20,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  architecture)));
      DegreeProgram businessAdmin =
          new DegreeProgram("Business Administration", DegreeProgramType.BACHELOR, 4, nus);
      businessAdmin.setCourses(
          List.of(
              new Course(
                  "Financial Accounting",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  businessAdmin),
              new Course(
                  "Managerial Economics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  businessAdmin),
              new Course(
                  "Principles of Marketing",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  businessAdmin),
              new Course(
                  "Corporate Finance",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  businessAdmin),
              new Course(
                  "Operations Management",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  businessAdmin),
              new Course(
                  "Strategic Management",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  businessAdmin),
              new Course(
                  "Organizational Behavior",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  businessAdmin),
              new Course(
                  "Business Law",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  businessAdmin),
              new Course(
                  "Business Analytics",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  businessAdmin),
              new Course(
                  "International Business",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  businessAdmin)));
      DegreeProgram pharmacy = new DegreeProgram("Pharmacy", DegreeProgramType.BACHELOR, 4, nus);
      pharmacy.setCourses(
          List.of(
              new Course(
                  "Pharmaceutical Chemistry",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  pharmacy),
              new Course(
                  "Pharmaceutics",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  pharmacy),
              new Course(
                  "Pharmacology", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, pharmacy),
              new Course(
                  "Pharmacotherapy",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  pharmacy),
              new Course(
                  "Clinical Pharmacy",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  pharmacy),
              new Course(
                  "Pharmacy Practice",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  pharmacy),
              new Course(
                  "Biopharmaceutics and Pharmacokinetics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  pharmacy),
              new Course(
                  "Pharmaceutical Analysis",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  pharmacy),
              new Course(
                  "Pharmacy Law and Ethics",
                  8,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  pharmacy),
              new Course(
                  "Research Project in Pharmacy",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  pharmacy)));
      DegreeProgram dataScienceAnalytics =
          new DegreeProgram("Data Science and Analytics", DegreeProgramType.BACHELOR, 4, nus);
      dataScienceAnalytics.setCourses(
          List.of(
              new Course(
                  "Calculus for Data Science",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  dataScienceAnalytics),
              new Course(
                  "Linear Algebra for Data Science",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  dataScienceAnalytics),
              new Course(
                  "Probability and Statistics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  dataScienceAnalytics),
              new Course(
                  "Data Structures and Algorithms",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  dataScienceAnalytics),
              new Course(
                  "Machine Learning",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  dataScienceAnalytics),
              new Course(
                  "Data Visualization",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  dataScienceAnalytics),
              new Course(
                  "Big Data Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  dataScienceAnalytics),
              new Course(
                  "Statistical Learning",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  dataScienceAnalytics),
              new Course(
                  "Optimization for Data Science",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  dataScienceAnalytics),
              new Course(
                  "Capstone Project",
                  16,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  dataScienceAnalytics)));
      nus.setDegreePrograms(
          List.of(computing, architecture, businessAdmin, pharmacy, dataScienceAnalytics));
      universities.add(nus);

      // University 11
      University sydney = new University("University of Sydney", CountryCode.AU, "USYD");
      DegreeProgram artsSocialSciences =
          new DegreeProgram("Arts and Social Sciences", DegreeProgramType.BACHELOR, 3, sydney);
      artsSocialSciences.setCourses(
          List.of(
              new Course(
                  "Sociology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsSocialSciences),
              new Course(
                  "Anthropology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsSocialSciences),
              new Course(
                  "Political Economy",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  artsSocialSciences),
              new Course(
                  "Media Studies",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  artsSocialSciences),
              new Course(
                  "History",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  artsSocialSciences),
              new Course(
                  "Philosophy",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  artsSocialSciences),
              new Course(
                  "English Literature",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsSocialSciences),
              new Course(
                  "Indigenous Studies",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  artsSocialSciences),
              new Course(
                  "Gender Studies",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  artsSocialSciences),
              new Course(
                  "Asian Studies",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  artsSocialSciences)));
      DegreeProgram commerce = new DegreeProgram("Commerce", DegreeProgramType.BACHELOR, 3, sydney);
      commerce.setCourses(
          List.of(
              new Course(
                  "Accounting", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, commerce),
              new Course(
                  "Finance", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, commerce),
              new Course(
                  "Marketing", 6, CourseTypeOfExam.PROJECT, CourseAttendance.ONLINE_SYNC, commerce),
              new Course(
                  "Business Analytics",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  commerce),
              new Course(
                  "International Business",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  commerce),
              new Course(
                  "Management", 6, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, commerce),
              new Course(
                  "Economics", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, commerce),
              new Course(
                  "Business Law",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  commerce),
              new Course(
                  "Human Resource Management",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  commerce),
              new Course(
                  "Innovation and Entrepreneurship",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  commerce)));
      DegreeProgram science = new DegreeProgram("Science", DegreeProgramType.BACHELOR, 3, sydney);
      science.setCourses(
          List.of(
              new Course(
                  "Biology", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, science),
              new Course(
                  "Chemistry", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, science),
              new Course("Physics", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, science),
              new Course(
                  "Mathematics", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, science),
              new Course(
                  "Geoscience", 6, CourseTypeOfExam.PRACTICAL, CourseAttendance.ON_SITE, science),
              new Course(
                  "Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  science),
              new Course(
                  "Computer Science",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  science),
              new Course(
                  "Environmental Science",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  science),
              new Course(
                  "Nutrition and Dietetics",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  science),
              new Course(
                  "Medical Science",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  science)));
      DegreeProgram engineeringHonours =
          new DegreeProgram("Engineering Honours", DegreeProgramType.BACHELOR, 4, sydney);
      engineeringHonours.setCourses(
          List.of(
              new Course(
                  "Civil Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours),
              new Course(
                  "Mechanical Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours),
              new Course(
                  "Electrical Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours),
              new Course(
                  "Software Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  engineeringHonours),
              new Course(
                  "Biomedical Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours),
              new Course(
                  "Chemical and Biomolecular Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours),
              new Course(
                  "Aerospace Engineering",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours),
              new Course(
                  "Engineering Professional Practice",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  engineeringHonours),
              new Course(
                  "Thesis A",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours),
              new Course(
                  "Thesis B",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringHonours)));
      sydney.setDegreePrograms(List.of(artsSocialSciences, commerce, science, engineeringHonours));
      universities.add(sydney);

      // University 12
      University ucl = new University("University College London", CountryCode.GB, "UCL");
      DegreeProgram artsAndSciences =
          new DegreeProgram("Arts and Sciences", DegreeProgramType.BACHELOR, 3, ucl);
      artsAndSciences.setCourses(
          List.of(
              new Course(
                  "Cultures",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsAndSciences),
              new Course(
                  "Health and Environment",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsAndSciences),
              new Course(
                  "Sciences and Engineering",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsAndSciences),
              new Course(
                  "Societies",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsAndSciences),
              new Course(
                  "Interdisciplinary Research Methods",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  artsAndSciences),
              new Course(
                  "Quantitative Methods",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  artsAndSciences),
              new Course(
                  "Language and Culture",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  artsAndSciences),
              new Course(
                  "Objects in Motion",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  artsAndSciences),
              new Course(
                  "Knowledge and Reality",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  artsAndSciences),
              new Course(
                  "Final Year Project",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  artsAndSciences)));
      DegreeProgram medicineUCL =
          new DegreeProgram("Medicine", DegreeProgramType.SINGLE_CYCLE_MASTER, 6, ucl);
      medicineUCL.setCourses(
          List.of(
              new Course(
                  "Fundamentals of Clinical Science 1",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "Fundamentals of Clinical Science 2",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "Integrated BSc",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "Clinical and Professional Practice 1",
                  30,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "Clinical and Professional Practice 2",
                  30,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "The Life Cycle",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "Cancer Biology",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  medicineUCL),
              new Course(
                  "Neuroscience and Behaviour",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "Infection and Defence",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineUCL),
              new Course(
                  "Endocrine Systems",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineUCL)));
      DegreeProgram economicsUCL =
          new DegreeProgram("Economics", DegreeProgramType.BACHELOR, 3, ucl);
      economicsUCL.setCourses(
          List.of(
              new Course(
                  "Microeconomics",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsUCL),
              new Course(
                  "Macroeconomics",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsUCL),
              new Course(
                  "Econometrics",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economicsUCL),
              new Course(
                  "Mathematics for Economists",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsUCL),
              new Course(
                  "Statistics for Economists",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsUCL),
              new Course(
                  "Applied Economics",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsUCL),
              new Course(
                  "History of Economic Thought",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsUCL),
              new Course(
                  "Public Economics",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsUCL),
              new Course(
                  "International Trade",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economicsUCL),
              new Course(
                  "Game Theory",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  economicsUCL)));
      DegreeProgram lawUCL = new DegreeProgram("Laws", DegreeProgramType.BACHELOR, 3, ucl);
      lawUCL.setCourses(
          List.of(
              new Course(
                  "Contract Law", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawUCL),
              new Course(
                  "Criminal Law", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawUCL),
              new Course(
                  "Public Law", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawUCL),
              new Course(
                  "Property Law I", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawUCL),
              new Course(
                  "Property Law II",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawUCL),
              new Course(
                  "Tort Law", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawUCL),
              new Course(
                  "Jurisprudence and Legal Theory",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  lawUCL),
              new Course(
                  "EU Law", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ONLINE_SYNC, lawUCL),
              new Course(
                  "International Law",
                  15,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  lawUCL),
              new Course(
                  "Company Law",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  lawUCL)));
      DegreeProgram csUCL =
          new DegreeProgram("Computer Science", DegreeProgramType.MASTER_I, 2, ucl);
      csUCL.setCourses(
          List.of(
              new Course(
                  "Algorithmics", 15, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, csUCL),
              new Course(
                  "Architecture and Hardware",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csUCL),
              new Course(
                  "Programming", 15, CourseTypeOfExam.PROJECT, CourseAttendance.ON_SITE, csUCL),
              new Course(
                  "Software Engineering",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  csUCL),
              new Course(
                  "Machine Learning",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  csUCL),
              new Course(
                  "Computer Graphics",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csUCL),
              new Course(
                  "Virtual Environments",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csUCL),
              new Course(
                  "Interaction Design",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  csUCL),
              new Course(
                  "Systems Engineering",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csUCL),
              new Course(
                  "Research Project",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csUCL)));
      ucl.setDegreePrograms(List.of(artsAndSciences, medicineUCL, economicsUCL, lawUCL, csUCL));
      universities.add(ucl);

      // University 13
      University mcgill = new University("McGill University", CountryCode.CA, "MCGILL");
      DegreeProgram scienceMcGill =
          new DegreeProgram("Science", DegreeProgramType.BACHELOR, 4, mcgill);
      scienceMcGill.setCourses(
          List.of(
              new Course(
                  "General Chemistry 1",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "General Chemistry 2",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "Calculus 1",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "Calculus 2",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "Linear Algebra",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "Mechanics",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "Waves and Optics",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "Introduction to Biology",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMcGill),
              new Course(
                  "Introduction to Computer Science",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  scienceMcGill),
              new Course(
                  "Introduction to Earth Systems",
                  3,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  scienceMcGill)));
      DegreeProgram artsMcGill = new DegreeProgram("Arts", DegreeProgramType.BACHELOR, 4, mcgill);
      artsMcGill.setCourses(
          List.of(
              new Course(
                  "Introduction to Political Science",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMcGill),
              new Course(
                  "Introduction to Sociology",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMcGill),
              new Course(
                  "Introduction to Psychology",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  artsMcGill),
              new Course(
                  "Introduction to Philosophy",
                  3,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  artsMcGill),
              new Course(
                  "World History",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMcGill),
              new Course(
                  "Microeconomics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMcGill),
              new Course(
                  "Macroeconomics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMcGill),
              new Course(
                  "English Literature",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  artsMcGill),
              new Course(
                  "Cultural Studies",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  artsMcGill),
              new Course(
                  "Linguistics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMcGill)));
      DegreeProgram engineeringMcGill =
          new DegreeProgram("Engineering", DegreeProgramType.BACHELOR, 4, mcgill);
      engineeringMcGill.setCourses(
          List.of(
              new Course(
                  "Introduction to Engineering Profession",
                  3,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Statics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Dynamics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Thermodynamics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Electrical Circuits",
                  4,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Materials Science",
                  4,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Engineering Mathematics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Computer-Aided Design",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  engineeringMcGill),
              new Course(
                  "Fluid Mechanics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill),
              new Course(
                  "Capstone Design Project",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  engineeringMcGill)));
      DegreeProgram managementMcGill =
          new DegreeProgram("Management", DegreeProgramType.BACHELOR, 4, mcgill);
      managementMcGill.setCourses(
          List.of(
              new Course(
                  "Introduction to Financial Accounting",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  managementMcGill),
              new Course(
                  "Introduction to Management Accounting",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  managementMcGill),
              new Course(
                  "Business Statistics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  managementMcGill),
              new Course(
                  "Organizational Behaviour",
                  3,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  managementMcGill),
              new Course(
                  "Marketing",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  managementMcGill),
              new Course(
                  "Corporate Finance",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  managementMcGill),
              new Course(
                  "Operations Management",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  managementMcGill),
              new Course(
                  "Information Systems",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  managementMcGill),
              new Course(
                  "Strategic Management",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  managementMcGill),
              new Course(
                  "Business Law",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  managementMcGill)));
      mcgill.setDegreePrograms(
          List.of(scienceMcGill, artsMcGill, engineeringMcGill, managementMcGill));
      universities.add(mcgill);

      // University 14
      University lmu =
          new University("Ludwig Maximilian University of Munich", CountryCode.DE, "LMU");
      DegreeProgram physicsLMU = new DegreeProgram("Physics", DegreeProgramType.BACHELOR, 3, lmu);
      physicsLMU.setCourses(
          List.of(
              new Course(
                  "Experimental Physics 1 (Mechanics)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Experimental Physics 2 (Thermo/EM)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Experimental Physics 3 (Optics/Quantum)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Theoretical Physics 1 (Mechanics)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Theoretical Physics 2 (EM)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Theoretical Physics 3 (Quantum)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Mathematical Methods",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Lab Course A",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Lab Course B",
                  8,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  physicsLMU),
              new Course(
                  "Computer Science for Physicists",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  physicsLMU)));
      DegreeProgram biologyLMU = new DegreeProgram("Biology", DegreeProgramType.BACHELOR, 3, lmu);
      biologyLMU.setCourses(
          List.of(
              new Course(
                  "General Biology I (Zoology)",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biologyLMU),
              new Course(
                  "General Biology II (Botany)",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biologyLMU),
              new Course(
                  "Cell Biology",
                  9,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  biologyLMU),
              new Course(
                  "Genetics", 9, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, biologyLMU),
              new Course(
                  "Microbiology",
                  9,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  biologyLMU),
              new Course("Ecology", 9, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, biologyLMU),
              new Course(
                  "Biochemistry",
                  9,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biologyLMU),
              new Course(
                  "Physiology",
                  9,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  biologyLMU),
              new Course(
                  "Statistics for Biologists",
                  7,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  biologyLMU),
              new Course(
                  "Evolution",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  biologyLMU)));
      DegreeProgram lawLMU =
          new DegreeProgram("Law", DegreeProgramType.SINGLE_CYCLE_MASTER, 5, lmu);
      lawLMU.setCourses(
          List.of(
              new Course(
                  "Civil Law I (BGB AT)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawLMU),
              new Course(
                  "Civil Law II (Law of Obligations)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawLMU),
              new Course(
                  "Civil Law III (Property Law)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawLMU),
              new Course(
                  "Criminal Law I (General Part)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawLMU),
              new Course(
                  "Criminal Law II (Special Part)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawLMU),
              new Course(
                  "Public Law I (Constitutional Law)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawLMU),
              new Course(
                  "Public Law II (Administrative Law)",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawLMU),
              new Course(
                  "Commercial and Company Law",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  lawLMU),
              new Course(
                  "Labor Law", 8, CourseTypeOfExam.WRITTEN, CourseAttendance.ONLINE_SYNC, lawLMU),
              new Course(
                  "European Law",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  lawLMU)));
      DegreeProgram philosophyLMU =
          new DegreeProgram("Philosophy", DegreeProgramType.BACHELOR, 3, lmu);
      philosophyLMU.setCourses(
          List.of(
              new Course(
                  "Introduction to Theoretical Philosophy",
                  12,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyLMU),
              new Course(
                  "Introduction to Practical Philosophy",
                  12,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyLMU),
              new Course(
                  "Logic", 12, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, philosophyLMU),
              new Course(
                  "History of Philosophy I (Antiquity)",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyLMU),
              new Course(
                  "History of Philosophy II (Medieval/Modern)",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyLMU),
              new Course(
                  "Metaphysics and Ontology",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  philosophyLMU),
              new Course(
                  "Epistemology",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  philosophyLMU),
              new Course(
                  "Ethics", 9, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, philosophyLMU),
              new Course(
                  "Political Philosophy",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyLMU),
              new Course(
                  "Philosophy of Mind",
                  9,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  philosophyLMU)));
      lmu.setDegreePrograms(List.of(physicsLMU, biologyLMU, lawLMU, philosophyLMU));
      universities.add(lmu);

      // University 15
      University edinburgh = new University("University of Edinburgh", CountryCode.GB, "ED");
      DegreeProgram informaticsEd =
          new DegreeProgram("Informatics", DegreeProgramType.BACHELOR, 4, edinburgh);
      informaticsEd.setCourses(
          List.of(
              new Course(
                  "Informatics 1 - Computation and Logic",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informaticsEd),
              new Course(
                  "Informatics 1 - Functional Programming",
                  20,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  informaticsEd),
              new Course(
                  "Informatics 1 - Data & Analysis",
                  20,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  informaticsEd),
              new Course(
                  "Informatics 2 - Algorithms & Data Structures",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informaticsEd),
              new Course(
                  "Informatics 2 - Software Engineering",
                  20,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  informaticsEd),
              new Course(
                  "Informatics 2 - Systems Programming",
                  20,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  informaticsEd),
              new Course(
                  "Calculus and its Applications",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informaticsEd),
              new Course(
                  "Linear Algebra",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informaticsEd),
              new Course(
                  "Discrete Mathematics",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  informaticsEd),
              new Course(
                  "Honours Project",
                  40,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  informaticsEd)));
      DegreeProgram philosophyEd =
          new DegreeProgram("Philosophy", DegreeProgramType.MASTER_II, 1, edinburgh);
      philosophyEd.setCourses(
          List.of(
              new Course(
                  "Mind, Language and Embodied Cognition",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyEd),
              new Course(
                  "Epistemology",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  philosophyEd),
              new Course(
                  "Ethics", 20, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, philosophyEd),
              new Course(
                  "Philosophy of Science",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  philosophyEd),
              new Course(
                  "Ancient Philosophy",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyEd),
              new Course(
                  "Modern Philosophy",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  philosophyEd),
              new Course(
                  "Logic", 20, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, philosophyEd),
              new Course(
                  "Metaphysics",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  philosophyEd),
              new Course(
                  "Political Philosophy",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  philosophyEd),
              new Course(
                  "Dissertation",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  philosophyEd)));
      DegreeProgram vetMed =
          new DegreeProgram("Veterinary Medicine", DegreeProgramType.BACHELOR, 5, edinburgh);
      vetMed.setCourses(
          List.of(
              new Course(
                  "Animal Body 1",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Animal Body 2",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Animal Life and Food Safety",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Professional and Clinical Skills 1",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Professional and Clinical Skills 2",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Veterinary Pathology",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Clinical Foundation Course",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Student-Led Research Component",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Final Year Rotations",
                  30,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  vetMed),
              new Course(
                  "Veterinary Public Health",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  vetMed)));
      DegreeProgram englishLit =
          new DegreeProgram("English Literature", DegreeProgramType.BACHELOR, 4, edinburgh);
      englishLit.setCourses(
          List.of(
              new Course(
                  "Literary Studies 1",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  englishLit),
              new Course(
                  "Literary Studies 2",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  englishLit),
              new Course(
                  "Critical Theory",
                  20,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  englishLit),
              new Course(
                  "Renaissance Literature",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  englishLit),
              new Course(
                  "Enlightenment and Romanticism",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  englishLit),
              new Course(
                  "Victorian Literature",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  englishLit),
              new Course(
                  "Modern and Contemporary Literature",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  englishLit),
              new Course(
                  "Scottish Literature",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  englishLit),
              new Course(
                  "American Literature",
                  20,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  englishLit),
              new Course(
                  "Dissertation",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  englishLit)));
      edinburgh.setDegreePrograms(List.of(informaticsEd, philosophyEd, vetMed, englishLit));
      universities.add(edinburgh);

      // University 16
      University copenhagen = new University("University of Copenhagen", CountryCode.DK, "UCPH");
      DegreeProgram medicineCopenhagen =
          new DegreeProgram("Medicine", DegreeProgramType.SINGLE_CYCLE_MASTER, 6, copenhagen);
      medicineCopenhagen.setCourses(
          List.of(
              new Course(
                  "Human Anatomy",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Medical Cell and Tissue Biology",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Biochemistry",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Physiology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Pharmacology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Pathology",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Immunology and Microbiology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Clinical Practice 1",
                  20,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen),
              new Course(
                  "Medical Ethics and Law",
                  5,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  medicineCopenhagen),
              new Course(
                  "Master's Thesis",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  medicineCopenhagen)));
      DegreeProgram lawCopenhagen =
          new DegreeProgram("Law", DegreeProgramType.BACHELOR, 3, copenhagen);
      lawCopenhagen.setCourses(
          List.of(
              new Course(
                  "Constitutional Law",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawCopenhagen),
              new Course(
                  "Criminal Law",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawCopenhagen),
              new Course(
                  "Property Law",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawCopenhagen),
              new Course(
                  "Law of Obligations",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawCopenhagen),
              new Course(
                  "Administrative Law",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawCopenhagen),
              new Course(
                  "EU Law",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  lawCopenhagen),
              new Course(
                  "International Law",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  lawCopenhagen),
              new Course(
                  "Legal Theory",
                  5,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  lawCopenhagen),
              new Course(
                  "Family and Inheritance Law",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawCopenhagen),
              new Course(
                  "Bachelor Project",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  lawCopenhagen)));
      DegreeProgram csCopenhagen =
          new DegreeProgram("Computer Science", DegreeProgramType.BACHELOR, 3, copenhagen);
      csCopenhagen.setCourses(
          List.of(
              new Course(
                  "Introduction to Programming",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csCopenhagen),
              new Course(
                  "Discrete Mathematics",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csCopenhagen),
              new Course(
                  "Algorithms and Data Structures",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csCopenhagen),
              new Course(
                  "Computer Architecture",
                  8,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csCopenhagen),
              new Course(
                  "Operating Systems",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csCopenhagen),
              new Course(
                  "Principles of Compilers",
                  4,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csCopenhagen),
              new Course(
                  "Computer Networks",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  csCopenhagen),
              new Course(
                  "Artificial Intelligence",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  csCopenhagen),
              new Course(
                  "Software Engineering",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csCopenhagen),
              new Course(
                  "Database Systems",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  csCopenhagen)));
      DegreeProgram filmMedia =
          new DegreeProgram("Film and Media Studies", DegreeProgramType.BACHELOR, 3, copenhagen);
      filmMedia.setCourses(
          List.of(
              new Course(
                  "Film History",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  filmMedia),
              new Course(
                  "Media Theory", 10, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, filmMedia),
              new Course(
                  "Film Analysis",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  filmMedia),
              new Course(
                  "Television Studies",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  filmMedia),
              new Course(
                  "Digital Media",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  filmMedia),
              new Course(
                  "Danish Cinema", 10, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, filmMedia),
              new Course(
                  "Documentary Film",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  filmMedia),
              new Course(
                  "Media Aesthetics",
                  10,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  filmMedia),
              new Course(
                  "Media Law and Ethics",
                  5,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  filmMedia),
              new Course(
                  "Bachelor Project",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  filmMedia)));
      copenhagen.setDegreePrograms(
          List.of(medicineCopenhagen, lawCopenhagen, csCopenhagen, filmMedia));
      universities.add(copenhagen);

      // University 17
      University amsterdam = new University("University of Amsterdam", CountryCode.NL, "UVA");
      DegreeProgram communicationScience =
          new DegreeProgram("Communication Science", DegreeProgramType.BACHELOR, 3, amsterdam);
      communicationScience.setCourses(
          List.of(
              new Course(
                  "Introduction to Communication Science",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  communicationScience),
              new Course(
                  "Research Methods I",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  communicationScience),
              new Course(
                  "Theories of Communication",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  communicationScience),
              new Course(
                  "Media Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  communicationScience),
              new Course(
                  "Corporate Communication",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  communicationScience),
              new Course(
                  "Political Communication",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  communicationScience),
              new Course(
                  "Media Entertainment",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  communicationScience),
              new Course(
                  "Communication Ethics",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  communicationScience),
              new Course(
                  "Statistics for Communication Science",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  communicationScience),
              new Course(
                  "Bachelor Thesis",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  communicationScience)));
      DegreeProgram pple =
          new DegreeProgram(
              "Politics, Psychology, Law and Economics", DegreeProgramType.BACHELOR, 3, amsterdam);
      pple.setCourses(
          List.of(
              new Course(
                  "Introduction to Politics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  pple),
              new Course(
                  "Introduction to Psychology",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  pple),
              new Course(
                  "Introduction to Law",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  pple),
              new Course(
                  "Introduction to Economics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  pple),
              new Course(
                  "Doing Research",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  pple),
              new Course(
                  "Global Justice", 6, CourseTypeOfExam.ORAL, CourseAttendance.ONLINE_SYNC, pple),
              new Course(
                  "Decision Making", 6, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, pple),
              new Course(
                  "Law, Justice and Morality",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  pple),
              new Course(
                  "Market Failures",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  pple),
              new Course(
                  "Bachelor Thesis",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  pple)));
      DegreeProgram aiAmsterdam =
          new DegreeProgram("Artificial Intelligence", DegreeProgramType.MASTER_I, 2, amsterdam);
      aiAmsterdam.setCourses(
          List.of(
              new Course(
                  "Machine Learning 1",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  aiAmsterdam),
              new Course(
                  "Intelligent Systems",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  aiAmsterdam),
              new Course(
                  "Natural Language Processing 1",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  aiAmsterdam),
              new Course(
                  "Computer Vision 1",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  aiAmsterdam),
              new Course(
                  "Information Retrieval",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  aiAmsterdam),
              new Course(
                  "Deep Learning",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  aiAmsterdam),
              new Course(
                  "Reinforcement Learning",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  aiAmsterdam),
              new Course(
                  "AI in Society",
                  6,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  aiAmsterdam),
              new Course(
                  "Research Methods for AI",
                  6,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  aiAmsterdam),
              new Course(
                  "Master Thesis AI",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  aiAmsterdam)));
      DegreeProgram physicsAmsterdam =
          new DegreeProgram("Physics and Astronomy", DegreeProgramType.BACHELOR, 3, amsterdam);
      physicsAmsterdam.setCourses(
          List.of(
              new Course(
                  "Calculus 1 for Physicists",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam),
              new Course(
                  "Mechanics and Relativity",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam),
              new Course(
                  "Linear Algebra for Physicists",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam),
              new Course(
                  "Electromagnetism",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam),
              new Course(
                  "Quantum Mechanics 1",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam),
              new Course(
                  "Thermodynamics and Statistical Physics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam),
              new Course(
                  "Experimental Physics",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam),
              new Course(
                  "Astrophysics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  physicsAmsterdam),
              new Course(
                  "Subatomic Physics",
                  6,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  physicsAmsterdam),
              new Course(
                  "Bachelor Project Physics",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  physicsAmsterdam)));
      amsterdam.setDegreePrograms(
          List.of(communicationScience, pple, aiAmsterdam, physicsAmsterdam));
      universities.add(amsterdam);

      // University 18
      University karolinska = new University("Karolinska Institute", CountryCode.SE, "KI");
      DegreeProgram medicineKarolinska =
          new DegreeProgram("Medicine", DegreeProgramType.SINGLE_CYCLE_MASTER, 6, karolinska);
      medicineKarolinska.setCourses(
          List.of(
              new Course(
                  "The Human Body",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "From Cell to Organism",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "Health and Disease 1",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "Health and Disease 2",
                  30,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "Clinical Medicine - Surgery",
                  30,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "Clinical Medicine - Internal Medicine",
                  30,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "Psychiatry and Neurology",
                  30,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "Primary Health Care",
                  30,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska),
              new Course(
                  "Scientific Development",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  medicineKarolinska),
              new Course(
                  "Degree Project in Medicine",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  medicineKarolinska)));
      DegreeProgram biomedicine =
          new DegreeProgram("Biomedicine", DegreeProgramType.BACHELOR, 3, karolinska);
      biomedicine.setCourses(
          List.of(
              new Course(
                  "General and Organic Chemistry",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Medical Biochemistry",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Cell Biology and Genetics",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Human Physiology",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Pharmacology and Toxicology",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Immunology and Microbiology",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Pathology",
                  15,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Neuroscience",
                  15,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  biomedicine),
              new Course(
                  "Biostatistics",
                  7,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  biomedicine),
              new Course(
                  "Degree Project in Biomedicine",
                  15,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  biomedicine)));
      DegreeProgram publicHealth =
          new DegreeProgram("Public Health Sciences", DegreeProgramType.MASTER_I, 2, karolinska);
      publicHealth.setCourses(
          List.of(
              new Course(
                  "Introduction to Public Health Sciences",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  publicHealth),
              new Course(
                  "Epidemiology I",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  publicHealth),
              new Course(
                  "Biostatistics I",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  publicHealth),
              new Course(
                  "Health Economics",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  publicHealth),
              new Course(
                  "Health Policy and Management",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  publicHealth),
              new Course(
                  "Global Health",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  publicHealth),
              new Course(
                  "Qualitative Methods",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  publicHealth),
              new Course(
                  "Epidemiology II",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  publicHealth),
              new Course(
                  "Biostatistics II",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  publicHealth),
              new Course(
                  "Master's Thesis",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  publicHealth)));
      DegreeProgram toxicology =
          new DegreeProgram("Toxicology", DegreeProgramType.MASTER_I, 2, karolinska);
      toxicology.setCourses(
          List.of(
              new Course(
                  "Principles of Toxicology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  toxicology),
              new Course(
                  "Target Organ Toxicology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  toxicology),
              new Course(
                  "Methods in Toxicology",
                  10,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  toxicology),
              new Course(
                  "Risk Assessment",
                  10,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  toxicology),
              new Course(
                  "Ecotoxicology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  toxicology),
              new Course(
                  "Carcinogenesis and Teratogenesis",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  toxicology),
              new Course(
                  "Neurotoxicology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  toxicology),
              new Course(
                  "Immunotoxicology",
                  10,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  toxicology),
              new Course(
                  "Laboratory Animal Science",
                  5,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  toxicology),
              new Course(
                  "Degree Project in Toxicology",
                  30,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  toxicology)));
      karolinska.setDegreePrograms(
          List.of(medicineKarolinska, biomedicine, publicHealth, toxicology));
      universities.add(karolinska);

      // University 19
      University melbourne = new University("University of Melbourne", CountryCode.AU, "UMELB");
      DegreeProgram scienceMelbourne =
          new DegreeProgram("Science", DegreeProgramType.BACHELOR, 3, melbourne);
      scienceMelbourne.setCourses(
          List.of(
              new Course(
                  "Biology: Life's Machinery",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMelbourne),
              new Course(
                  "Chemistry 1",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMelbourne),
              new Course(
                  "Physics 1",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMelbourne),
              new Course(
                  "Calculus 2",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMelbourne),
              new Course(
                  "Linear Algebra",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  scienceMelbourne),
              new Course(
                  "Data Analysis 1",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  scienceMelbourne),
              new Course(
                  "Genetics in the Media",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  scienceMelbourne),
              new Course(
                  "Earth Systems",
                  12,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  scienceMelbourne),
              new Course(
                  "Psychology 1",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  scienceMelbourne),
              new Course(
                  "Foundations of Computing",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  scienceMelbourne)));
      DegreeProgram artsMelbourne =
          new DegreeProgram("Arts", DegreeProgramType.BACHELOR, 3, melbourne);
      artsMelbourne.setCourses(
          List.of(
              new Course(
                  "Power", 12, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, artsMelbourne),
              new Course(
                  "Identity",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMelbourne),
              new Course(
                  "Language",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  artsMelbourne),
              new Course(
                  "Culture",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  artsMelbourne),
              new Course(
                  "Media and Communication",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  artsMelbourne),
              new Course(
                  "Philosophy", 12, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, artsMelbourne),
              new Course(
                  "History", 12, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, artsMelbourne),
              new Course(
                  "Criminology",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  artsMelbourne),
              new Course(
                  "Sociology",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  artsMelbourne),
              new Course(
                  "Economics",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  artsMelbourne)));
      DegreeProgram designMelbourne =
          new DegreeProgram("Design", DegreeProgramType.BACHELOR, 3, melbourne);
      designMelbourne.setCourses(
          List.of(
              new Course(
                  "Foundations of Design: Representation",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  designMelbourne),
              new Course(
                  "Design Studio Alpha",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  designMelbourne),
              new Course(
                  "History of Design",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  designMelbourne),
              new Course(
                  "Digital Design",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  designMelbourne),
              new Course(
                  "Construction as Alchemy",
                  12,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  designMelbourne),
              new Course(
                  "Environmental Building Systems",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  designMelbourne),
              new Course(
                  "Urban Design",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  designMelbourne),
              new Course(
                  "Landscape Architecture",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  designMelbourne),
              new Course(
                  "Graphic Design",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  designMelbourne),
              new Course(
                  "Design Thesis",
                  25,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  designMelbourne)));
      DegreeProgram commerceMelbourne =
          new DegreeProgram("Commerce", DegreeProgramType.BACHELOR, 3, melbourne);
      commerceMelbourne.setCourses(
          List.of(
              new Course(
                  "Introductory Microeconomics",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  commerceMelbourne),
              new Course(
                  "Introductory Macroeconomics",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  commerceMelbourne),
              new Course(
                  "Accounting Reports and Analysis",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  commerceMelbourne),
              new Course(
                  "Principles of Finance",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  commerceMelbourne),
              new Course(
                  "Quantitative Methods 1",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  commerceMelbourne),
              new Course(
                  "Organisational Behaviour",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  commerceMelbourne),
              new Course(
                  "Principles of Marketing",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  commerceMelbourne),
              new Course(
                  "Business Law",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  commerceMelbourne),
              new Course(
                  "Actuarial Studies",
                  12,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  commerceMelbourne),
              new Course(
                  "Management",
                  12,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  commerceMelbourne)));
      melbourne.setDegreePrograms(
          List.of(scienceMelbourne, artsMelbourne, designMelbourne, commerceMelbourne));
      universities.add(melbourne);

      // University 20
      University tsinghua = new University("Tsinghua University", CountryCode.CN, "THU");
      DegreeProgram csTsinghua =
          new DegreeProgram(
              "Computer Science and Technology", DegreeProgramType.BACHELOR, 4, tsinghua);
      csTsinghua.setCourses(
          List.of(
              new Course(
                  "Fundamentals of Programming",
                  4,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csTsinghua),
              new Course(
                  "Data Structures",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csTsinghua),
              new Course(
                  "Discrete Mathematics",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csTsinghua),
              new Course(
                  "Computer Architecture",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  csTsinghua),
              new Course(
                  "Operating Systems",
                  4,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csTsinghua),
              new Course(
                  "Principles of Compilers",
                  4,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csTsinghua),
              new Course(
                  "Computer Networks",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  csTsinghua),
              new Course(
                  "Artificial Intelligence",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  csTsinghua),
              new Course(
                  "Software Engineering",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  csTsinghua),
              new Course(
                  "Database Systems",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  csTsinghua)));
      DegreeProgram economicsTsinghua =
          new DegreeProgram("Economics and Finance", DegreeProgramType.BACHELOR, 4, tsinghua);
      economicsTsinghua.setCourses(
          List.of(
              new Course(
                  "Microeconomics",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTsinghua),
              new Course(
                  "Macroeconomics",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTsinghua),
              new Course(
                  "Econometrics",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTsinghua),
              new Course(
                  "Political Economy",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTsinghua),
              new Course(
                  "Corporate Finance",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  economicsTsinghua),
              new Course(
                  "Investment",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  economicsTsinghua),
              new Course(
                  "International Finance",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  economicsTsinghua),
              new Course(
                  "Chinese Economy",
                  3,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ON_SITE,
                  economicsTsinghua),
              new Course(
                  "Game Theory",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsTsinghua),
              new Course(
                  "Behavioral Economics",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  economicsTsinghua)));
      DegreeProgram architectureTsinghua =
          new DegreeProgram("Architecture", DegreeProgramType.BACHELOR, 5, tsinghua);
      architectureTsinghua.setCourses(
          List.of(
              new Course(
                  "Architectural Design Studio I",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  architectureTsinghua),
              new Course(
                  "Architectural Design Studio II",
                  8,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  architectureTsinghua),
              new Course(
                  "History of Chinese Architecture",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  architectureTsinghua),
              new Course(
                  "History of Foreign Architecture",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  architectureTsinghua),
              new Course(
                  "Building Structures",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  architectureTsinghua),
              new Course(
                  "Building Physics",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  architectureTsinghua),
              new Course(
                  "Urban Planning Principles",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  architectureTsinghua),
              new Course(
                  "Digital Design and Tectonics",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  architectureTsinghua),
              new Course(
                  "Green Building",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  architectureTsinghua),
              new Course(
                  "Professional Practice",
                  2,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  architectureTsinghua)));
      DegreeProgram lawTsinghua = new DegreeProgram("Law", DegreeProgramType.BACHELOR, 4, tsinghua);
      lawTsinghua.setCourses(
          List.of(
              new Course(
                  "Jurisprudence", 3, CourseTypeOfExam.ORAL, CourseAttendance.ON_SITE, lawTsinghua),
              new Course(
                  "Constitutional Law",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTsinghua),
              new Course(
                  "Civil Law", 5, CourseTypeOfExam.WRITTEN, CourseAttendance.ON_SITE, lawTsinghua),
              new Course(
                  "Criminal Law",
                  5,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTsinghua),
              new Course(
                  "Administrative Law",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTsinghua),
              new Course(
                  "Economic Law",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  lawTsinghua),
              new Course(
                  "International Law",
                  3,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_SYNC,
                  lawTsinghua),
              new Course(
                  "Intellectual Property Law",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_ASYNC,
                  lawTsinghua),
              new Course(
                  "Procedural Law",
                  4,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  lawTsinghua),
              new Course(
                  "Legal Practice",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  lawTsinghua)));
      DegreeProgram journalism =
          new DegreeProgram(
              "Journalism and Communication", DegreeProgramType.BACHELOR, 4, tsinghua);
      journalism.setCourses(
          List.of(
              new Course(
                  "Introduction to Journalism",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  journalism),
              new Course(
                  "Communication Theory",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ON_SITE,
                  journalism),
              new Course(
                  "News Reporting and Writing",
                  4,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  journalism),
              new Course(
                  "Media Ethics and Law",
                  3,
                  CourseTypeOfExam.ORAL,
                  CourseAttendance.ONLINE_ASYNC,
                  journalism),
              new Course(
                  "New Media Studies",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_SYNC,
                  journalism),
              new Course(
                  "Broadcast Journalism",
                  4,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  journalism),
              new Course(
                  "Data Journalism",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ONLINE_ASYNC,
                  journalism),
              new Course(
                  "International Communication",
                  3,
                  CourseTypeOfExam.WRITTEN,
                  CourseAttendance.ONLINE_SYNC,
                  journalism),
              new Course(
                  "Public Relations",
                  3,
                  CourseTypeOfExam.PROJECT,
                  CourseAttendance.ON_SITE,
                  journalism),
              new Course(
                  "Internship",
                  6,
                  CourseTypeOfExam.PRACTICAL,
                  CourseAttendance.ON_SITE,
                  journalism)));
      tsinghua.setDegreePrograms(
          List.of(csTsinghua, economicsTsinghua, architectureTsinghua, lawTsinghua, journalism));
      universities.add(tsinghua);

      universityRepository.saveAll(universities);
      log.info("Finished preloading data.");
    };
  }
}
