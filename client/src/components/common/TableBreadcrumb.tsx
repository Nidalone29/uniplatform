import {
  Breadcrumb,
  BreadcrumbItem,
  BreadcrumbLink,
  BreadcrumbList,
  BreadcrumbPage,
  BreadcrumbSeparator,
} from "@/components/ui/breadcrumb"
import { Link, useMatches } from "react-router";


export function TableBreadcrumb() {
  const matches = useMatches();

  return (
    <Breadcrumb>
      <BreadcrumbList>
        {
          matches.filter((match) => match.handle).map((match, i, arr) => (
            (i != arr.length - 1) ? (
              <>
                <BreadcrumbItem>
                  <BreadcrumbLink asChild>
                    <Link to={match.pathname} viewTransition>{"" + match.handle}</Link>
                  </BreadcrumbLink>
                </BreadcrumbItem>
                <BreadcrumbSeparator />
              </>
            ) : (
              <BreadcrumbItem>
                <BreadcrumbPage>{"" + match.handle}</BreadcrumbPage>
              </BreadcrumbItem>
            )
          ))
        }
      </BreadcrumbList>
    </Breadcrumb>
  );
}
