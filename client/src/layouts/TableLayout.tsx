import { TableBreadcrumb } from "@/components/common/TableBreadcrumb";
import { ModeToggle } from "@/components/common/ModeToggle";
import { ThemeProvider } from "@/components/common/ThemeProvider";
import { Toaster } from "@/components/ui/sonner";
import { Outlet } from "react-router";

export function TableLayout() {
  return (
    <ThemeProvider defaultTheme="light" storageKey="vite-ui-theme">
      <ModeToggle />
      <Toaster position="top-center" richColors />
      <TableBreadcrumb />
      <Outlet />
    </ThemeProvider>
  );
}
