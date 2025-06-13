import {
  RouterProvider,
} from "react-router";
import { router } from './routes.ts';
import { createRoot } from 'react-dom/client';
import './index.css';

createRoot(document.getElementById('root')!).render(
  <RouterProvider router={router} />
)
