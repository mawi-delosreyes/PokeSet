export const getTeamList = async (userId: number, access: boolean) => {
  const res = await fetch(`http://localhost:8080/team/getTeamList?userId=${userId}&access=${access}`);
  if (!res.ok) {
    throw new Error('Failed to fetch Team');
  }
  return await res.json();
};

export const getTeamData = async (teamId: number, userId: number, access:boolean) => {
  const res = await fetch(`http://localhost:8080/team/getTeamInfo?teamId=${teamId}&userId=${userId}&access=${access}`);
  if (!res.ok) {
    throw new Error('Failed to fetch Team Details');
  }
  return await res.json();
};
