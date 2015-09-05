import sbt._
import Keys._

/**
 * based on https://github.com/harrah/xsbt/wiki/Getting-Started-Multi-Project
 */
object TopBuild extends Build {

  // aggregate: running a task on the aggregate project will also run it on the aggregated projects.
  // dependsOn: a project depends on code in another project.
  // without dependsOn, you'll get a compiler error: "object bar is not a member of package
  // com.alvinalexander".
  lazy val root = Project(id = "top",
                          base = file(".")) aggregate(day1, day2, day3) dependsOn(day1, day2, day3)

  // sub-project in the day-1 subdirectory
  lazy val day1 = Project(id = "day-1",
                         base = file("day-1"))

  // sub-project in the day-2 subdirectory
  lazy val day2 = Project(id = "day-2",
                         base = file("day-2"))
  
  // sub-project in the day-3 subdirectory
  lazy val day3 = Project(id = "day-3",
                         base = file("day-3"))
}
