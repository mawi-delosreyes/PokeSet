import React from 'react';

type ButtonProps = {
  children: React.ReactNode;
  onClick?: () => void;
};

export function Button({ children, onClick, className }: ButtonProps & { className?: string }) {
    return (
    <button
    className={`${className || ''}`}
    onClick={onClick}
    >
      {children}
    </button>
  );
}