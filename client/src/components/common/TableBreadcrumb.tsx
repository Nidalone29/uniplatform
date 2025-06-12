import {
  Breadcrumb,
  BreadcrumbItem,
  BreadcrumbLink,
  BreadcrumbList,
  BreadcrumbPage,
  BreadcrumbSeparator,
} from "@/components/ui/breadcrumb"
import { useMatches } from "react-router";


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
                  <BreadcrumbLink href={match.pathname}>{"" + match.handle}</BreadcrumbLink>
                </BreadcrumbItem>
                <BreadcrumbSeparator />
              </>
            ) : (
              <>
                <BreadcrumbItem>
                  <BreadcrumbPage>{"" + match.handle}</BreadcrumbPage>
                </BreadcrumbItem>
              </>
            )
          ))
        }
      </BreadcrumbList>
    </Breadcrumb>
  );
}
