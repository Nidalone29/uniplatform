import { TableBreadcrumb } from "@/components/common/TableBreadcrumb";
import { Toaster } from "@/components/ui/sonner";
import { Outlet } from "react-router";

export function TableLayout() {
  return (
    <>
      <Toaster position="top-center" richColors />
      <TableBreadcrumb />
      <Outlet />
    </>
  );
}
