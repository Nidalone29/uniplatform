import { Toaster } from "@/components/ui/sonner";

import { SiteHeader } from "@/components/common/SiteHeader";
import { ThemeProvider } from "@/components/common/ThemeProvider";
import { TableLayout } from "@/layouts/TableLayout";

export function MainPage() {
  return (
    <ThemeProvider defaultTheme="light" storageKey="vite-ui-theme">
      <Toaster position="top-center" richColors />
      <SiteHeader />
      <TableLayout />
    </ThemeProvider>
  );
}
