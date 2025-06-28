import { ModeToggle } from "@/components/common/ModeToggle";
import { TableBreadcrumb } from "@/components/common/TableBreadcrumb";

export function SiteHeader() {
  return (
    <div className="[--header-height:calc(--spacing(14))]">
      <header className="flex h-(--header-height) shrink-0 items-center gap-2 border-b">
        <div className="flex w-full items-center gap-1 px-4 lg:gap-2 lg:px-6">
          <h1 className="text-base font-medium">Uni Platform</h1>
          <div className="ml-auto flex align-middle justify-center">
            <TableBreadcrumb />
          </div>
          <div className="ml-auto flex items-center gap-2">
            <ModeToggle />
          </div>
        </div>
      </header>
    </div>
  );
}
